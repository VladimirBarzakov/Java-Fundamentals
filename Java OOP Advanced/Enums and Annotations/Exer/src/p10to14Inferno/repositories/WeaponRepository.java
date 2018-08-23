package p10to14Inferno.repositories;

import p10to14Inferno.models.Weapon;
import p10to14Inferno.models.types.GemType;

import java.util.LinkedHashMap;
import java.util.Map;


public class WeaponRepository {
    private Map<String, Weapon> weapons;

    public WeaponRepository() {
        this.weapons=new LinkedHashMap<>();
    }

    private boolean doesWeaponExist(String name){
        return this.weapons.containsKey(name);
    }

    public boolean addWeapon(Weapon weapon){
        if (this.doesWeaponExist(weapon.getName())){
            return false;
        }
        this.weapons.put(weapon.getName(),weapon);
        return true;
    }

    public void addGem(String weaponName, int index, GemType gem){
        if (!this.doesWeaponExist(weaponName)){
            return;
        }
        Weapon weapon = this.weapons.get(weaponName);
        weapon.addGemToSocket(index, gem);
    }

    public void removeGem(String weaponName, int index){
        if (!this.doesWeaponExist(weaponName)){
            return;
        }
        Weapon weapon = this.weapons.get(weaponName);
        weapon.addGemToSocket(index, null);
    }

    public String print(String weaponName){
        if (!this.doesWeaponExist(weaponName)){
            return "Weapon with that name does not exist";
        }
        return this.weapons.get(weaponName).toString();
    }

    public String getBestWeaponOfTwo(String firstWeaponName,String secondWeaponName){
        if (!this.doesWeaponExist(firstWeaponName) ||
                !this.doesWeaponExist(secondWeaponName)){
            return "Weapon with that name does not exist";
        }
        Weapon firstWeapon = this.weapons.get(firstWeaponName);
        Weapon secondWeapon = this.weapons.get(secondWeaponName);
        if (firstWeapon.compareTo(secondWeapon)>=0){
            return firstWeapon.toStringWithStats();
        } else{
            return secondWeapon.toStringWithStats();
        }
    }


}
