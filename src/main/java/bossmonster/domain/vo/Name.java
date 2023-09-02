package bossmonster.domain.vo;

import java.util.Objects;

public class Name {

    private final String value;

    public Name(final String value) {
        validateNonNull(value);
        this.value = value;
    }

    private void validateNonNull(final String value) {
        if (Objects.isNull(value)) {
            throw new IllegalStateException("플레이어의 이름은 null 일 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
