package bossmonster.view;

import bossmonster.view.dto.BossStatusResponse;
import bossmonster.view.dto.PlayerStatusResponse;

public class OutputView {

    private static final String ERROR_MESSAGE_TEMPLATE = "[ERROR] %s%n";

    public void printErrorMessage(final String message) {
        System.out.println();
        System.out.printf(ERROR_MESSAGE_TEMPLATE, message);
    }

    public void printStartState(final BossStatusResponse bossStatus, final String playerName, final PlayerStatusResponse playerStatus) {
        System.out.println();
        System.out.println("============================");
        System.out.printf("BOSS HP [%s/%s]%n", bossStatus.getCurrentHealthPoint(), bossStatus.getOriginHealthPoint());
        System.out.println("----------------------------");
        System.out.println("   ^-^");
        System.out.println(" / 0 0 \\");
        System.out.println("(   \"   )");
        System.out.println(" \\  -  /");
        System.out.println("  - ^ -");
        System.out.println("----------------------------");
        System.out.printf("%s HP [%s/%s] MP [%s/%s]%n",
                playerName,
                playerStatus.getCurrentHealthPoint(),
                playerStatus.getOriginHealthPoint(),
                playerStatus.getCurrentManaPoint(),
                playerStatus.getOriginManaPoint()
        );
        System.out.println("============================");
    }

    public void printProgressState(final BossStatusResponse bossStatus, final String playerName, final PlayerStatusResponse playerStatus) {
        System.out.println();
        System.out.println("============================");
        System.out.printf("BOSS HP [%s/%s]%n", bossStatus.getCurrentHealthPoint(), bossStatus.getOriginHealthPoint());
        System.out.println("----------------------------");
        System.out.println("   ^-^");
        System.out.println(" / x x \\");
        System.out.println("(   \"\\  )");
        System.out.println(" \\  ^  /");
        System.out.println("  - ^ -");
        System.out.println("----------------------------");
        System.out.printf("%s HP [%s/%s] MP [%s/%s]%n",
                playerName,
                playerStatus.getCurrentHealthPoint(),
                playerStatus.getOriginHealthPoint(),
                playerStatus.getCurrentManaPoint(),
                playerStatus.getOriginManaPoint()
        );
        System.out.println("============================");
    }

    public void printPhysicalAttackMessage() {
        System.out.println();
        System.out.println("물리 공격을 했습니다.");
    }

    public void printMagicalAttackMessage() {
        System.out.println();
        System.out.println("마법 공격을 했습니다.");
    }

    public void printBossAttackMessage(final int damage) {
        System.out.println("보스가 공격 했습니다.");
        System.out.printf("HP -%s%n", damage);
    }

    public void printPlayerWinMessage(final String name, final int attackCount) {
        System.out.println();
        System.out.printf("%s 님이 %s번의 전투 끝에 보스 몬스터를 잡았습니다.", name, attackCount);
    }

    public void printBossMinMessage(final BossStatusResponse bossStatus, final String playerName, final PlayerStatusResponse playerStatus) {
        System.out.println();
        System.out.println("============================");
        System.out.printf("BOSS HP [%s/%s]%n", bossStatus.getCurrentHealthPoint(), bossStatus.getOriginHealthPoint());
        System.out.println("----------------------------");
        System.out.println("   ^-^");
        System.out.println(" / ^ ^ \\");
        System.out.println("(   \"\\  )");
        System.out.println(" \\  3  /");
        System.out.println("  - ^ -");
        System.out.println("----------------------------");
        System.out.printf("%s HP [%s/%s] MP [%s/%s]%n",
                playerName,
                playerStatus.getCurrentHealthPoint(),
                playerStatus.getOriginHealthPoint(),
                playerStatus.getCurrentManaPoint(),
                playerStatus.getOriginManaPoint()
        );
        System.out.println("============================");

        System.out.println();
        System.out.println("HP가 0이 되었습니다.");
        System.out.println("보스 레이드에 실패했습니다.");
    }
}
