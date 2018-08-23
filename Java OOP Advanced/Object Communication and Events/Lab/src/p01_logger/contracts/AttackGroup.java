package p01_logger.contracts;

public interface AttackGroup {
    void addMember(Attacker attacker);
    void groupTarget(Target target);
    void groupAttack();
    void groupTargetAndAttack(Target target);

}
