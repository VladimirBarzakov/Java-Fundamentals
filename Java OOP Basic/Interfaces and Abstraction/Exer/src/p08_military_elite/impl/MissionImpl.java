package p08_military_elite.impl;

import p08_military_elite.interfaces.Mission;

public class MissionImpl implements Mission {
    private static final String  IN_PROGRESS_STATE ="inProgress";
    private static final String  FINISHED_STATE ="Finished";

    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (!IN_PROGRESS_STATE.equals(state)&& !FINISHED_STATE.equals(state)){
            throw new IllegalArgumentException();
        }
        this.state=state;
    }

    public void CompleteMission(){
        if (!this.state.equals(FINISHED_STATE)){
            this.state=FINISHED_STATE;
        }
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",this.codeName,this.state);
    }
}