package bossmonster.domain.vo;

public class ManaPoint {

    private final int value;

    public ManaPoint(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < 0) {
            throw new IllegalStateException("MP 는 0 보다 작을 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
