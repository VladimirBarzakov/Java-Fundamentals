import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeArrayList {


    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\resources\\list.ser";
        String outputPath = System.getProperty("user.dir")+"\\resources\\list.ser";
        List<Double> list = new ArrayList<>();
        Collections.addAll(list, 3.4,23.5,232.1,43.55);

        //serializeList(list,outputPath);
        List<Double> copy = deSerializeList(path);

    }

    private static List<Double> deSerializeList(String path) {
        List<Double> result = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))){
            result = (ArrayList<Double>)input.readObject();

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return result;
    }

    private static void serializeList(List<Double> list, String outputPath) {

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(outputPath))){
            output.writeObject(list);
            } catch (IOException e){
            e.printStackTrace();
            }
    }
}
