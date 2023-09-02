package bossmonster.view;

import java.util.Arrays;

public enum AttackCommand {
    PHYSICAL_ATTACK("1"),
    MAGICAL_ATTACK("2");

    private final String command;

    AttackCommand(final String command) {
        this.command = command;
    }

    public static AttackCommand from(final String input) {
        return Arrays.stream(values())
                .filter(attackCommand -> attackCommand.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 또는 2 를 입력해주세요."));
    }

    public boolean isPhysicalAttack() {
        return this == PHYSICAL_ATTACK;
    }
}
