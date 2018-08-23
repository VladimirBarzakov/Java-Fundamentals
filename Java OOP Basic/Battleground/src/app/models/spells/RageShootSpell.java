package app.models.spells;

import app.constants.spellsParams.SpellParams;
import app.constants.unitsParams.MarineParams;
import app.interfaces.gameModels.Spell;

public class RageShootSpell extends BaseSpell implements Spell {
    public RageShootSpell() {
        super(MarineParams.ATTACK_POINTS, SpellParams.RAGE_SHOOT_ENERGY_COST);
    }
}
