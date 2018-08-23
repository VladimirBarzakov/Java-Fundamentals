package models.dataHandlers;

import contracts.DataHandler;

abstract class BaseDataHandler implements DataHandler {
    private int countAppended;

    BaseDataHandler() {
        this.countAppended = 0;
    }

    int getCountAppended() {
        return this.countAppended;
    }

    void setCountAppended(int countAppended) {
        this.countAppended = countAppended;
    }

    @Override
    public String toString() {
        return String.format("Messages appended: %d",this.countAppended);
    }
}
