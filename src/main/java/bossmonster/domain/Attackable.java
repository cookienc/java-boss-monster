package bossmonster.domain;

public interface Attackable {

    void attack(final Damageable target, final AttackSkill attackSkill);
}
