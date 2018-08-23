package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private static BufferedReader reader;

    public Reader() {
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    public String read(){
        String input=null;

        try {
            input=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    public void close(){
        try {
            this.reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
