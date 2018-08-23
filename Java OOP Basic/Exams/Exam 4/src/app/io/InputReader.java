package app.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private BufferedReader reader;

    public InputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine(){
        try {
            return this.reader.readLine();
        } catch (IOException e) {
            ;
        }
        return null;
    }

    public void close(){
        if (this.reader!=null){
            try {
                this.reader.close();
            } catch (IOException e) {
                ;
            }
        }
    }
}
