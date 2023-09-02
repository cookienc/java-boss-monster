package bossmonster.domain.vo;

public class HealthPoint {

    private int value;

    public HealthPoint(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < 0) {
            throw new IllegalStateException("HP 는 0 보다 작을 수 없습니다.");
        }
    }

    public void minus(final Damage damage) {
        this.value -= damage.getValue();
    }

    public boolean isZero() {
        return value == 0;
    }

    public int getValue() {
        return value;
    }
}
