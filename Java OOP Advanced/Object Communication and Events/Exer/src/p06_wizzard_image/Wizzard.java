package p06_wizzard_image;

import java.util.LinkedHashMap;
import java.util.Map;

public class Wizzard {
    private static int counter = 0;
    private static int ROOT_NUM = 0;
    public static Map<Integer, Wizzard> mirrors = new LinkedHashMap<>();
    private String name;
    private int magicPower;
    private Wizzard leftChild;
    private Wizzard rightChild;
    private int id;

    public Wizzard(String name, int magicPower) {
        this.name = name;
        this.magicPower = magicPower;
        this.leftChild = null;
        this.rightChild = null;
        this.id = counter;
        mirrors.put(counter, this);
        counter++;
    }

    public String getName() {
        return this.name;
    }

    public int getMagicPower() {
        return this.magicPower;
    }

    public Wizzard getLeftChild() {
        return this.leftChild;
    }

    public Wizzard getRightChild() {
        return this.rightChild;
    }

    public static void setCounter(int counter) {
        Wizzard.counter = counter;
    }

    public void setLeftChild(Wizzard leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Wizzard rightChild) {
        this.rightChild = rightChild;
    }

    public int getId() {
        return this.id;
    }

    public static void reflection(int id){
        Wizzard wizzard = mirrors.get(id);
        if (wizzard==null){
            return;
        }
        wizzard.castRecursiveReflection(wizzard);

    }

    private static void castRecursiveReflection(Wizzard wizzard){
        if (wizzard==null){
            return;
        }else{
            System.out.println(String.format("%s %d casts Reflection",wizzard.name, wizzard.id));
            if (wizzard.leftChild==null){
                wizzard.leftChild = new Wizzard(wizzard.name, wizzard.magicPower/2);
            } else{
                castRecursiveReflection(wizzard.leftChild);
            }
            if (wizzard.rightChild==null){
                wizzard.rightChild = new Wizzard(wizzard.name, wizzard.magicPower/2);
            } else{
                castRecursiveReflection(wizzard.rightChild);
            }
        }
    }

    public static void fireball(int id){
        Wizzard wizzard = mirrors.get(id);
        if (wizzard==null){
            return;
        }
        wizzard.castRecursiveFireball(wizzard);

    }

    private static void castRecursiveFireball(Wizzard wizzard) {
        if (wizzard==null){
            return;
        }else{
            System.out.println(String.format("%s %d casts Fireball for %d damage",wizzard.name, wizzard.id, wizzard.magicPower));
            castRecursiveFireball(wizzard.leftChild);
            castRecursiveFireball(wizzard.rightChild);
        }
    }
}
