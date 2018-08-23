package io;

import contracts.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static constants.IOConstants.END_COMMAND;


public class BuffedReaderImpl implements Reader {
    private BufferedReader reader;

    public BuffedReaderImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String line = null;
        try {
            line = reader.readLine();

            if (END_COMMAND.equals(line)){
                this.reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
