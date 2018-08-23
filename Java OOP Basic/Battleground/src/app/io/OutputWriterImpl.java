package app.io;

import app.interfaces.core.OutputWriter;

public class OutputWriterImpl implements OutputWriter {

    public void writeLine(String line) {
        System.out.println(line);
    }
}
