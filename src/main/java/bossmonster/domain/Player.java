package bossmonster.domain;

import bossmonster.domain.vo.Damage;
import bossmonster.domain.vo.ManaPoint;
import bossmonster.domain.vo.Name;
import bossmonster.domain.vo.Status;

public class Player extends Damageable implements Attackable {

    private static final AttackSkill PHYSICAL_ATTACK = new AttackSkill(new Damage(10), new ManaPoint(0));
    private static final AttackSkill MAGICAL_ATTACK = new AttackSkill(new Damage(20), new ManaPoint(30));
    private static final ManaPoint RESTORE_MANA = new ManaPoint(10);

    private final Name name;
    private final Status status;

    public Player(final Name name, final Status status) {
        this.name = name;
        this.status = status;
    }

    public void attackPhysical(final Damageable target) {
        attack(target, PHYSICAL_ATTACK);
        status.plusManaPoint(RESTORE_MANA);
    }

    public void attackMagic(final Damageable target) {
        attack(target, MAGICAL_ATTACK);
    }

    @Override
    protected void minusHealthPoint(final Damage attackDamage) {
        status.minusHealthPoint(attackDamage);
    }

    @Override
    public boolean isDead() {
        return status.isDead();
    }

    @Override
    public void attack(final Damageable target, final AttackSkill attackSkill) {
        target.minusHealthPoint(attackSkill.getAttackDamage());
        status.minusManaPoint(attackSkill.getConsumeManaPoint());
    }

    public Name getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }
}
