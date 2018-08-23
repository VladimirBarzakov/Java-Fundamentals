package p05to07_border_control;

import java.util.Set;

public interface BorderControlable {
    boolean isIdFake(Set<String> bannedIdPieces);

    String getId();
}
