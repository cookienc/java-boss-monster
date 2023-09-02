package bossmonster.domain.vo;

public class Status {

    private final HealthPoint currentHealthPoint;
    private final HealthPoint origineHealthPoint;
    private final ManaPoint currentManaPoint;
    private final ManaPoint originManaPoint;

    public Status(final HealthPoint healthPoint) {
        this(healthPoint, new ManaPoint(0));
    }

    public Status(final HealthPoint healthPoint, final ManaPoint manaPoint) {
        this.currentHealthPoint = healthPoint;
        this.origineHealthPoint = healthPoint;
        this.currentManaPoint = manaPoint;
        this.originManaPoint = manaPoint;
    }

    public void plusManaPoint(final ManaPoint restoreMana) {
        currentManaPoint.plus(restoreMana);
    }

    public void minusHealthPoint(final Damage attackDamage) {
        currentHealthPoint.minus(attackDamage);
    }

    public void minusManaPoint(final ManaPoint consumeManaPoint) {
        currentManaPoint.minus(consumeManaPoint);
    }

    public boolean isDead() {
        return currentHealthPoint.isZero();
    }

    public HealthPoint getCurrentHealthPoint() {
        return currentHealthPoint;
    }

    public ManaPoint getCurrentManaPoint() {
        return currentManaPoint;
    }

    public HealthPoint getOrigineHealthPoint() {
        return origineHealthPoint;
    }

    public ManaPoint getOriginManaPoint() {
        return originManaPoint;
    }
}
