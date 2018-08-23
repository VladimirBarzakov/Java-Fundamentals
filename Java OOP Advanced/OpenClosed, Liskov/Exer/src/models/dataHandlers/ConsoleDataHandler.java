package models.dataHandlers;

import contracts.DataHandler;

public class ConsoleDataHandler extends BaseDataHandler implements DataHandler {

    public ConsoleDataHandler() {
        super();
    }

    @Override
    public void saveData(String message) {
        System.out.println(message);
        super.setCountAppended(super.getCountAppended()+1);
    }

    @Override
    @Deprecated
    public String releaseData() {
        return null;
    }
}
