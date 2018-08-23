package controller;

import models.Cluster;
import models.Organism;
import models.cells.baseClasses.Cell;
import models.cells.boodCells.RedBloodCell;
import models.cells.boodCells.WhiteBloodCell;
import models.cells.microbes.Bacteria;
import models.cells.microbes.Fungi;
import models.cells.microbes.Virus;

import java.util.LinkedHashMap;
import java.util.Map;

public class HealthManager {

    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms=new LinkedHashMap<>();
    }

    public String checkCondition(String organismName){
        if (this.organisms.containsKey(organismName)){
            return this.organisms.get(organismName).toString();
        }
        return null;
    }
    public String createOrganism(String name) {
        if (this.organisms.containsKey(name)){
            return String.format("Organism %s already exists",name);
        }
        this.organisms.put(name, new Organism(name));
        return String.format("Created organism %s",name);
    }
    public String addCluster(String organismName, String id, int rows, int cols){
        if (!this.organisms.containsKey(organismName)){
            return null;
        }
        if (this.organisms.get(organismName).getClusters().containsKey(id)){
            return null;
        }
        Cluster cluster = new Cluster(id,rows,cols);
        this.organisms.get(organismName)
                .getClusters()
                .put(id,cluster);
        this.organisms.get(organismName).getClustersActivationOrder().addLast(cluster);
        return String.format("Organism %s: Created cluster %s",organismName,id);
    }
    public String addCell(String organismName,
                          String clusterId,
                          String cellType,
                          String cellId,
                          int health,
                          int positionRow,
                          int positionCol,
                          int additionalProperty){
        if (!this.organisms.containsKey(organismName)){
            return null;
        }
        if (!this.organisms.get(organismName).getClusters().containsKey(clusterId)){
            return null;
        }
        Cluster cluster = this.organisms.get(organismName).getClusters().get(clusterId);
        if (positionRow>=cluster.getCells().length ||
                positionCol>=cluster.getCells()[positionRow].length){
            return null;
        }
        if (cluster.getCells()[positionRow][positionCol]!=null){
            return null;
        }
        Cell cell = null;
        switch (cellType){
            case "RedBloodCell":
                cell = new RedBloodCell(cellId,health,positionRow,positionCol,additionalProperty);
                break;
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId,health,positionRow,positionCol,additionalProperty);
                break;
            case "Bacteria":
                cell = new Bacteria(cellId,health,positionRow,positionCol,additionalProperty);
                break;
            case "Virus":
                cell = new Virus(cellId,health,positionRow,positionCol,additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId,health,positionRow,positionCol,additionalProperty);
                break;
        }
        if (cell==null){
            return null;
        }
        cluster.getCells()[positionRow][positionCol]=cell;
        cluster.setCellSize(cluster.getCellSize()+1);
        return String.format("Organism %s: Created cell %s in cluster %s",organismName,cellId,clusterId);
    }
    public String activateCluster(String organismName){
        if (!this.organisms.containsKey(organismName) || this.organisms.get(organismName).getClustersActivationOrder().size()==0){
            return null;
        }

        Cluster cluster = this.organisms.get(organismName).getClustersActivationOrder().removeFirst();
        initiateClusterActivation(cluster);
        this.organisms.get(organismName).getClustersActivationOrder().addLast(cluster);
        return String.format("Organism %s: Activated cluster %s. Cells left: %d",
                organismName,
                cluster.getName(),
                cluster.getCellSize());
    }

    private void initiateClusterActivation(Cluster cluster) {
        if (cluster.getCellSize()<2){
            return;
        }
        int[] cellPosition = findNextCell(cluster.getCells(),0,0);
        Cell firstCell = cluster.getCells()[cellPosition[0]][cellPosition[1]];
        while (cluster.getCellSize()>1){
            cluster.getCells()[cellPosition[0]][cellPosition[1]]=null;
            cellPosition = findNextCell(cluster.getCells(),
                    firstCell.getPositionRow(),
                    firstCell.getPositionCol()+1);
            firstCell=firstCell.cellEngagement(cluster.getCells()[cellPosition[0]][cellPosition[1]]);
            cluster.setCellSize(cluster.getCellSize()-1);
        }
        cluster.getCells()[cellPosition[0]][cellPosition[1]]=firstCell;
        firstCell.setPositionRow(cellPosition[0]);
        firstCell.setPositionCol(cellPosition[1]);
    }

    private int[] findNextCell(Cell[][] cells, int startRow, int startCol) {

        for (int r = startRow; r < cells.length; r++) {
            for (int c = 0; c < cells[r].length; c++) {
                if (r==startRow && c<startCol){
                    continue;
                }
                if (cells[r][c]!=null){
                   return new int[]{r,c};
                }
            }
        }
        return new int[]{-1,0};
    }

}
