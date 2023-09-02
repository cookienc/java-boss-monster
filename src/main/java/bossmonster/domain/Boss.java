package bossmonster.domain;

import bossmonster.domain.vo.Damage;
import bossmonster.domain.vo.HealthPoint;
import bossmonster.domain.vo.Status;

public class Boss extends Damageable implements Attackable {

    private final Status status;

    public Boss(final HealthPoint healthPoint) {
        this.status = new Status(healthPoint);
    }

    @Override
    public void attack(final Damageable target, final AttackSkill attackSkill) {
        target.minusHealthPoint(attackSkill.getAttackDamage());
    }

    @Override
    protected void minusHealthPoint(final Damage attackDamage) {
        status.minusHealthPoint(attackDamage);
    }

    @Override
    public boolean isDead() {
        return status.isDead();
    }

    public Status getStatus() {
        return status;
    }
}
