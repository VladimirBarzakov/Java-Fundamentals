package app.io;

import app.enums.CommandTypes;
import app.interfaces.core.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {

    private BufferedReader bufferedReader;

    public InputReaderImpl() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        String input = bufferedReader.readLine().trim();
        if (CommandTypes.GAME_OVER.toString().equals(input)){
            if (bufferedReader!=null){
                bufferedReader.close();
            }
        }
        return input;
    }
}
