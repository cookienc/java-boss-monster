package bossmonster.domain.vo;

public class ManaPoint {

    private int value;

    public ManaPoint(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < 0) {
            throw new IllegalStateException("MP 는 0 보다 작을 수 없습니다.");
        }
    }

    public void plus(final ManaPoint manaPoint) {
        this.value += manaPoint.getValue();
    }

    public void minus(final ManaPoint manaPoint) {
        this.value -= manaPoint.getValue();
    }

    public boolean isBigger(final ManaPoint target) {
        return value > target.value;
    }

    public void fillMax(final ManaPoint maxManaPoint) {
        value = maxManaPoint.value;
    }

    public int getValue() {
        return value;
    }
}
