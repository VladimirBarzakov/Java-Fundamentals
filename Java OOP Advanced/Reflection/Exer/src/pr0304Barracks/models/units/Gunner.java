package pr0304Barracks.models.units;

public class Gunner extends AbstractUnit {
    private static int GUNNER_HEALTH = 20;
    private static int GUNNER_DAMAGE = 20;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
