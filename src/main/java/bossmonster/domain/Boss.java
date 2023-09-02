package bossmonster.domain;

import bossmonster.domain.vo.Damage;
import bossmonster.domain.vo.HealthPoint;

public class Boss extends Damageable implements Attackable {

    private final HealthPoint healthPoint;

    public Boss(final HealthPoint healthPoint) {
        this.healthPoint = healthPoint;
    }

    @Override
    public void attack(final Damageable target, final AttackSkill attackSkill) {
        target.minusHealthPoint(attackSkill.getAttackDamage());
    }

    @Override
    protected void minusHealthPoint(final Damage attackDamage) {
        healthPoint.minus(attackDamage);
    }

    public HealthPoint getHealthPoint() {
        return healthPoint;
    }
}
