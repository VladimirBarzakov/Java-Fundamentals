package p10to14Inferno.models;

import p10to14Inferno.annotations.CustomAnnotation;
import p10to14Inferno.models.types.GemType;
import p10to14Inferno.models.types.WeaponType;

import java.lang.annotation.Documented;

@CustomAnnotation(author = "Pesho", revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})

public class Weapon implements Comparable<Weapon>{
    private String name;
    private WeaponType weaponType;
    private GemType[] sockets;

    public Weapon(String name,WeaponType weaponType) {
        this.name=name;
        this.weaponType = weaponType;
        this.sockets=new GemType[this.weaponType.getNumOfSocket()];
    }


    public String getName() {
        return this.name;
    }

    public void addGemToSocket(int socketIndex, GemType gem){
        if (socketIndex<0 ||socketIndex>=this.sockets.length){
            return;
        }
        this.sockets[socketIndex]=gem;
    }

    public void removeGemFromSocket(int socketIndex){
        this.addGemToSocket(socketIndex,null);
    }

    private int getMinDamage(){
        int result = this.weaponType.getMinDamage();
        for (GemType gem:this.sockets) {
            if (gem==null){
                continue;
            }
            result+=2*gem.getStrength()+gem.getAgility();
        }
        return result;
    }

    private int getMaxDamage(){
        int result = this.weaponType.getMaxDamage();
        for (GemType gem:this.sockets) {
            if (gem==null){
                continue;
            }
            result+=3*gem.getStrength()+4*gem.getAgility();
        }
        return result;
    }

    private int getStrengthPoints(){
        int result = 0;
        for (GemType gem:this.sockets) {
            if (gem==null){
                continue;
            }
            result+=gem.getStrength();
        }
        return result;
    }

    private int getAgilityPoints(){
        int result = 0;
        for (GemType gem:this.sockets) {
            if (gem==null){
                continue;
            }
            result+=gem.getAgility();
        }
        return result;
    }

    private int getVitalityPoints(){
        int result = 0;
        for (GemType gem:this.sockets) {
            if (gem==null){
                continue;
            }
            result+=gem.getVitality();
        }
        return result;
    }

    private double getWeaponLevel(){
        return (((double) this.getMinDamage()+(double) this.getMaxDamage())/2d)+this.getStrengthPoints()+this.getAgilityPoints()+this.getVitalityPoints();
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.getMinDamage(), this.getMaxDamage(), this.getStrengthPoints(),
                this.getAgilityPoints(), this.getVitalityPoints());
    }

    public String toStringWithStats(){
        return String.format("%s (Item Level: %s)",this.toString(),this.getWeaponLevel());
    }


    @Override
    public int compareTo(Weapon other) {
        return Double.compare(this.getWeaponLevel(),other.getWeaponLevel());
    }
}
