package models.dataHandlers;

import contracts.DataHandler;

public class LogFile extends BaseDataHandler implements DataHandler {
    private StringBuilder builder;
    private int size;

    public LogFile() {
        this.builder = new StringBuilder();
        this.size=0;
    }

    @Override
    public void saveData(String message) {
        this.builder.append(message).append(System.lineSeparator());
        super.setCountAppended(super.getCountAppended()+1);
        for (int i = 0; i < message.length(); i++) {
            if(Character.isLetter(message.charAt(i))){
                this.size+=(int)message.charAt(i);
            }
        }
    }

    @Override
    public String releaseData() {
        return this.builder.toString();
    }

    @Override
    public String toString() {
        return String.format("%s, File size: %d",super.toString(),this.size);
    }
}
