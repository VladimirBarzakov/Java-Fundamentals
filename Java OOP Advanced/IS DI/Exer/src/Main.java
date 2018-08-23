import IO.ConsoleReader;
import IO.ConsoleWriter;
import contracts.*;
import contracts.Runnable;
import controllers.ControllerImpl;
import core.CommandHandlerImpl;
import core.Engine;
import database.BoatRepository;
import database.BoatSimulatorDatabase;
import database.EngineRepository;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Repository<Boat> boatRepository = new BoatRepository();
        Repository<BoatEngine> boatEngineRepository = new EngineRepository();
        BoatSimulatorDatabase database = new BoatSimulatorDatabase(boatRepository,boatEngineRepository);
        Controller controller = new ControllerImpl(database);
        CommandHandler commandHandler = new CommandHandlerImpl(controller);

        Runnable engine = new Engine(reader, writer,commandHandler,database);
        engine.run();
    }
}
