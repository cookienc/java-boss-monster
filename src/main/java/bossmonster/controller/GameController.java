package bossmonster.controller;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;
import bossmonster.domain.vo.HealthPoint;
import bossmonster.domain.vo.ManaPoint;
import bossmonster.domain.vo.Name;
import bossmonster.domain.vo.Status;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.StatusDto;

import java.util.Objects;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        final Boss boss = getBoss();

        final Name name = getName();
        final Status status = getStatus();
        final Player player = new Player(name, status);
    }

    private Boss getBoss() {
        try {
            final String input = inputView.inputBossHealthPoint();
            return createBoss(input);
        } catch (final IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getBoss();
        }
    }

    private Boss createBoss(final String healthPoint) {
        final int bossHealthPoint = changeStringToInt(healthPoint);
        if (bossHealthPoint < 100 || bossHealthPoint > 300) {
            throw new IllegalArgumentException("보스 HP 는 100 ~ 300 사이로 입력해주세요.");
        }

        return new Boss(new HealthPoint(bossHealthPoint));
    }

    private Player getPlayer() {
        try {
            final Name name = getName();
            final Status status = getStatus();

            return new Player(name, status);
        } catch (final IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getPlayer();
        }
    }

    private Name getName() {
        try {
            final String name = inputView.inputPlayerName();
            if (Objects.isNull(name) || name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException("이름은 1 ~ 5 자 사이로 입력해주세요.");
            }
            return new Name(name);
        } catch (final IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getName();
        }
    }

    private Status getStatus() {
        try {
            final StatusDto statusDto = inputView.inputPlayerStatus();
            final int healthPoint = changeStringToInt(statusDto.getHealthPoint());
            final int manaPoint = changeStringToInt(statusDto.getManaPoint());

            final int statusPoint = healthPoint + manaPoint;
            if (statusPoint != 200) {
                throw new IllegalArgumentException("HP 와 MP 의 합은 200 이어야 합니다. 현재 합 : " + statusPoint);
            }

            return new Status(new HealthPoint(healthPoint), new ManaPoint(manaPoint));
        } catch (final IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getStatus();
        }
    }

    private int changeStringToInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력해주세요.");
        }
    }
}
