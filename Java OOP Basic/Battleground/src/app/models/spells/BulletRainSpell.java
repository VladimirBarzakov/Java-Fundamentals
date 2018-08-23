package app.models.spells;

import app.constants.spellsParams.SpellParams;
import app.constants.unitsParams.CarrierParams;
import app.interfaces.gameModels.Spell;

public class BulletRainSpell extends BaseSpell implements Spell {
    public BulletRainSpell() {
        super(CarrierParams.ATTACK_POINTS, SpellParams.BULLET_RAIN_ENERGY_COST);
    }
}
