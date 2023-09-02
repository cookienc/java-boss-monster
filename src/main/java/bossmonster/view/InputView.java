package bossmonster.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public String inputBossHealthPoint() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
        return SCANNER.nextLine();
    }

    public String inputPlayerName() {
        System.out.println();
        System.out.println("플레이어의 이름을 입력해주세요.");
        return SCANNER.nextLine();
    }

    public StatusDto inputPlayerStatus() {
        System.out.println();
        System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");

        try {
            final String input = SCANNER.nextLine();
            final String[] status = input.split(",");

            if (status.length != 2) {
                throw new IllegalArgumentException(",로 구분되는 HP 와 MP 를 입력해주세요.");
            }
            return new StatusDto(status[0], status[1]);
        } catch (final IllegalArgumentException e) {
            return inputPlayerStatus();
        }
    }

    public void printStartMessage() {
        System.out.println("보스 레이드를 시작합니다!");
        System.out.println();
    }

    public String selectAttackCommand() {
        System.out.println("어떤 공격을 하시겠습니까?");
        System.out.println("1. 물리 공격");
        System.out.println("2. 마법 공격");
        return SCANNER.nextLine();
    }
}
