package p01_logger.logger;

public class CombatLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (type==LogType.ATTACK|| type==LogType.MAGIC){
            System.out.println(type.name()+": "+message);
        }
        super.passToSuccessor(type,message);
    }
}
