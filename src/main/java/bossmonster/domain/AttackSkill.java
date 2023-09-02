package bossmonster.domain;

import bossmonster.domain.vo.Damage;
import bossmonster.domain.vo.ManaPoint;

public class AttackSkill {

    private final Damage attackDamage;
    private final ManaPoint consumeManaPoint;

    public AttackSkill(final Damage attackDamage, final ManaPoint consumeManaPoint) {
        this.attackDamage = attackDamage;
        this.consumeManaPoint = consumeManaPoint;
    }

    public Damage getAttackDamage() {
        return attackDamage;
    }

    public ManaPoint getConsumeManaPoint() {
        return consumeManaPoint;
    }
}
