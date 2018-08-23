package app.factories;

import app.interfaces.gameModels.Spell;
import app.models.spells.BulletRainSpell;
import app.models.spells.RageShootSpell;

public final class SpellFactory {
    public static final Spell createBulletRain() {
        return new BulletRainSpell();
    }

    public static final Spell createRageShoot() {
        return new RageShootSpell();
    }

}
