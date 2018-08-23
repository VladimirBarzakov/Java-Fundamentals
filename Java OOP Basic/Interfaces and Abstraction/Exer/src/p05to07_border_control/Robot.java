package p05to07_border_control;

import java.util.Set;

public class Robot extends Minion implements BorderControlable {
    private String id;

    public Robot(String model, String id) {
        super(model);
        this.id = id;
    }


    public String getId() {
        return this.id;
    }

    @Override
    public boolean isIdFake(Set<String> bannedIdPieces) {
        for (String bannedIdPiece:bannedIdPieces) {
            if (this.id.endsWith(bannedIdPiece)){
                return true;
            }
        }
        return false;
    }
}
