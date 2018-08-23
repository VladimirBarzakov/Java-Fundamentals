import model.Colonist;
import model.Colony;
import model.colinists.*;
import view.Reader;
import view.Writer;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Writer writer = new Writer();

        String line = reader.read();
        int[] colonyParams = Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Colony colony = new Colony(colonyParams[0],colonyParams[1]);


        while (true){
            line=reader.read();
            if ("end".equals(line)){
                reader.close();
                break;
            }
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String result=null;
            switch (command){
                case "insert":
                    String clazz = tokens[1];
                    String id = tokens[2];
                    String familyId = tokens[3];
                    int talent = Integer.parseInt(tokens[4]);
                    int age = Integer.parseInt(tokens[5]);
                    Colonist colonist= null;
                    switch (clazz){
                        case "SoftwareEngineer":
                            colonist=new SoftwareEngineer(id,familyId,talent,age);
                            break;
                        case "HardwareEngineer":
                            colonist=new HardwareEngineer(id,familyId,talent,age);
                            break;
                        case "Soldier":
                            colonist=new Soldier(id,familyId,talent,age);
                            break;
                        case "GeneralPractitioner":
                            colonist=new GeneralPractitioner(id,familyId,talent,age,tokens[6]);
                            break;
                        case "Surgeon":
                            colonist=new Surgeon(id,familyId,talent,age,tokens[6]);
                            break;
                    }
                    if (colonist!=null){
                        try {
                            colony.addColonist(colonist);
                        } catch (IllegalArgumentException e){
                            result=e.getMessage();
                        }
                    }
                    break;
                case "remove":
                    String mutator = tokens[1];
                    switch (mutator){
                        case "family":
                            colony.removeFamily(tokens[2]);
                            break;
                        case "colonist":
                            colony.removeColonist(tokens[2],tokens[3]);
                            break;
                    }
                    break;
                case "potential":
                    result=String.format("potential: %d",colony.getPotential());
                    break;
                case "capacity":
                    result=colony.getCapacity();
                    break;
                case "family":
                    String familyName = tokens[1];
                    List<Colonist> colonists = colony.getColonistsByFamilyId(familyName);
                    if (colonists==null){
                        writer.write("family does not exist");
                        continue;
                    }
                    StringBuilder builder = new StringBuilder();
                    builder.append(String.format("%s:",familyName));
                    for (Colonist member:colonists) {
                        builder.append(System.lineSeparator()).append(member.toString());
                    }
                    result=builder.toString();
                    break;
                case "grow":
                    int years = Integer.parseInt(tokens[1]);
                    colony.grow(years);
                    break;
            }
            if (result!=null){
                writer.writeLine(result);
            }
        }
    }
}
