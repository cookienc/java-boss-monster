package bossmonster.domain.vo;

public class Status {

    private final HealthPoint healthPoint;
    private final ManaPoint manaPoint;

    public Status(final HealthPoint healthPoint, final ManaPoint manaPoint) {
        this.healthPoint = healthPoint;
        this.manaPoint = manaPoint;
    }

    public void plusManaPoint(final ManaPoint restoreMana) {
        manaPoint.plus(restoreMana);
    }

    public void minusHealthPoint(final Damage attackDamage) {
        healthPoint.minus(attackDamage);
    }

    public void minusManaPoint(final ManaPoint consumeManaPoint) {
        manaPoint.minus(consumeManaPoint);
    }

    public HealthPoint getHealthPoint() {
        return healthPoint;
    }

    public ManaPoint getManaPoint() {
        return manaPoint;
    }
}
