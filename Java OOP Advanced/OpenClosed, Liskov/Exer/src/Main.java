import contracts.Logger;
import contracts.Reader;
import contracts.Writer;
import factories.AppenderFactory;
import factories.LayoutFactory;
import io.BuffedReaderImpl;
import io.ConsoleWriter;
import models.loggers.MessageLogger;

import static constants.IOConstants.END_COMMAND;

public class Main {
    public static void main(String[] args) {
        //IO Dependency
        Reader reader = new BuffedReaderImpl();
        Writer writer = new ConsoleWriter();

        //Factory Dependency
        AppenderFactory appenderFactory = new AppenderFactory();
        LayoutFactory layoutFactory = new LayoutFactory();

        //Controller
        Logger logger = new MessageLogger(layoutFactory,appenderFactory);

        int appenderCounter = Integer.parseInt(reader.readLine());
        String line;
        while (true){
            line=reader.readLine();
            if (END_COMMAND.equals(line)){
                writer.writeLine(logger.generateFullReport());
                break;
            }
            if (appenderCounter>0){
                logger.addAppender(line);
                appenderCounter--;
                continue;
            }
            logger.processLog(line);
        }

    }
}
