package p03_man_kind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens;
        Student student;
        Worker worker;
        try {
            tokens=reader.readLine().split("\\s+");
            student=new Student(tokens[0], tokens[1], tokens[2]);
            tokens = reader.readLine().split("\\s+");
            worker=new Worker(tokens[0], tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(student.toString());
        System.out.println(worker.toString());

    }
}
