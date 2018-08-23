package p10to14Inferno.factories;

import p10to14Inferno.models.types.GemType;

public final class GemFactory {
    public GemFactory() {
    }

    public final GemType createGem(String gemTypeName){
        GemType gem = null;
        try {
            gem = GemType.valueOf(GemType.class, gemTypeName);
        } catch (NullPointerException|IllegalArgumentException e){
            return null;
        }
        return gem;
    }
}
