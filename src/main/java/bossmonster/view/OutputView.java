package bossmonster.view;

import bossmonster.view.dto.BossStatusResponse;
import bossmonster.view.dto.PlayerStatusResponse;

public class OutputView {

    private static final String ERROR_MESSAGE_TEMPLATE = "[ERROR] %s%n";

    public void printErrorMessage(final String message) {
        System.out.println();
        System.out.printf(ERROR_MESSAGE_TEMPLATE, message);
    }

    public void printStartStatus(final BossStatusResponse bossStatus, final String playerName, final PlayerStatusResponse playerStatus) {
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
                bossStatus.getCurrentHealthPoint(),
                bossStatus.getOriginHealthPoint(),
                playerStatus.getCurrentManaPoint(),
                playerStatus.getOriginManaPoint()
        );
        System.out.println("============================");
    }
}
