package p02_kings_gambit.models.logger;

import p02_kings_gambit.contracts.Handler;
import p02_kings_gambit.contracts.Soldier;

import java.util.Map;

public abstract class BaseLogger implements Handler {
    private Map<String, Soldier> army;
    private Handler successor;

    protected BaseLogger(Map<String, Soldier> army) {
        this.army = army;
    }

    public void setSuccessor(Handler handler){
        this.successor=handler;
    }

    protected Map<String, Soldier> getArmy() {
        return this.army;
    }


    protected void passToSuccessor(String message){
        if (this.successor!=null){
            this.successor.handle(message);
        }
    }

    public abstract void handle(String message);

}
