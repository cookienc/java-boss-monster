package bossmonster.domain;

import bossmonster.domain.vo.Damage;
import bossmonster.domain.vo.HealthPoint;
import bossmonster.domain.vo.ManaPoint;
import bossmonster.domain.vo.Name;

public class Player extends Damageable implements Attackable {

    private static final AttackSkill PHYSICAL_ATTACK = new AttackSkill(new Damage(10), new ManaPoint(0));
    private static final AttackSkill MAGICAL_ATTACK = new AttackSkill(new Damage(20), new ManaPoint(30));
    private static final ManaPoint RESTORE_MANA = new ManaPoint(10);

    private final Name name;
    private final HealthPoint healthPoint;
    private final ManaPoint manaPoint;

    public Player(final Name name, final HealthPoint healthPoint, final ManaPoint manaPoint) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.manaPoint = manaPoint;
    }

    public void attackPhysical(final Damageable target, final AttackSkill attackSkill) {
        attack(target, PHYSICAL_ATTACK);
        manaPoint.plus(RESTORE_MANA);
    }

    public void attackMagic(final Damageable target, final AttackSkill attackSkill) {
        attack(target, MAGICAL_ATTACK);
    }

    @Override
    protected void minusHealthPoint(final Damage attackDamage) {
        healthPoint.minus(attackDamage);
    }

    @Override
    public void attack(final Damageable target, final AttackSkill attackSkill) {
        target.minusHealthPoint(attackSkill.getAttackDamage());
        manaPoint.minus(attackSkill.getConsumeManaPoint());
    }

    public Name getName() {
        return name;
    }

    public HealthPoint getHealthPoint() {
        return healthPoint;
    }

    public ManaPoint getManaPoint() {
        return manaPoint;
    }
}
