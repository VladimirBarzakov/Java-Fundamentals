package models;

import java.util.*;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;
    private Deque<Cluster> clustersActivationOrder;

    public Organism(String name) {
        this.name = name;
        this.clusters= new LinkedHashMap<>();
        this.clustersActivationOrder=new ArrayDeque<>();
    }

    private int getCellCount(){
        return this.clusters.values().stream().mapToInt(Cluster::getCellSize).sum();
    }

    public Map<String, Cluster> getClusters() {
        return this.clusters;
    }

    public Deque<Cluster> getClustersActivationOrder() {
        return this.clustersActivationOrder;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Organism - %s",this.name)).append(System.lineSeparator());
        builder.append(String.format("--Clusters: %d",this.clusters.size())).append(System.lineSeparator());
        builder.append(String.format("--Cells: %d",this.getCellCount()));
        this.clustersActivationOrder.forEach(x->builder.append(System.lineSeparator()).append(x.toString()));
        return builder.toString();
    }
}
