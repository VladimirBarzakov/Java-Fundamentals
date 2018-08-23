package p10to14Inferno.factories;

import p10to14Inferno.models.Weapon;
import p10to14Inferno.models.types.WeaponType;

public final class WeaponFactory {

    public WeaponFactory() {
    }

    public static Weapon createWeapon(String name, String weaponTypeName){
        Weapon weapon = null;
        WeaponType weaponType = null;
        try {
            weaponType = WeaponType.valueOf(WeaponType.class, weaponTypeName);
        } catch (NullPointerException | IllegalArgumentException e){
            return null;
        }
        weapon = new Weapon(name, weaponType);
        return weapon;
    }
}
