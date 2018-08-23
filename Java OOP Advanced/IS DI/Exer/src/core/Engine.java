package core;

import contracts.CommandHandler;
import contracts.Reader;
import contracts.Runnable;
import contracts.Writer;
import database.BoatSimulatorDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private Reader reader;
    private Writer writer;
    private CommandHandler commandHandler;
    private BoatSimulatorDatabase database;

    public Engine(Reader reader,
                  Writer writer,
                  CommandHandler commandHandler,
                  BoatSimulatorDatabase database )
    {
        this.reader=reader;
        this.writer=writer;
        this.commandHandler = commandHandler;
        this.database=database;
    }

    public void run()
    {
        String line;
        while (true)
        {
            line=this.reader.readLine();
            if ("End".equals(line)){
                break;
            }
            List<String> tokens = Arrays.asList(line.split("\\\\"));
            String name = tokens.get(0);
            List<String>parameters = tokens.stream().skip(1).collect(Collectors.toList());
            String commandResult = this.commandHandler.executeCommand(name, parameters);
            this.writer.writeLine(commandResult);
        }
    }
}
