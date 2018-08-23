package p10to14Inferno.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private BufferedReader reader;

    public InputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine(){
        String line = null;
        try {
            line = this.reader.readLine();
        } catch (IOException ignore){
            ;
        }
        return line;
    }

    public void close(){
        if (this.reader!=null){
            try {
                this.reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
