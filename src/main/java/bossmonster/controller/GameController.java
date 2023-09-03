package bossmonster.controller;

import bossmonster.domain.Boss;
import bossmonster.domain.DamageGenerator;
import bossmonster.domain.Player;
import bossmonster.domain.vo.HealthPoint;
import bossmonster.domain.vo.ManaPoint;
import bossmonster.domain.vo.Name;
import bossmonster.domain.vo.Status;
import bossmonster.view.AttackCommand;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.StatusDto;
import bossmonster.view.dto.BossStatusResponse;
import bossmonster.view.dto.PlayerStatusResponse;

import java.util.Objects;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame(final DamageGenerator damageGenerator) {
        final Boss boss = getBoss();

        final Name name = getName();
        final Status status = getStatus();
        final Player player = new Player(name, status);

        inputView.printStartMessage();
        outputView.printStartState(
                BossStatusResponse.from(boss.getStatus()),
                player.getName().getValue(),
                PlayerStatusResponse.from(player.getStatus())
        );

        int attackCount = 0;
        while (true) {

            try {
                final AttackCommand attackCommand = getAttackCommand();
                attackPlayer(attackCommand, player, boss);
            } catch (final IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                continue;
            }

            attackCount++;
            if (boss.isDead()) {
                outputView.printPlayerWinMessage(player.getName().getValue(), attackCount);
                break;
            }

            attackBoss(damageGenerator);
            if (player.isDead()) {
                outputView.printBossMinMessage(
                        BossStatusResponse.from(boss.getStatus()),
                        player.getName().getValue(),
                        PlayerStatusResponse.from(player.getStatus())
                );
                break;
            }

            outputView.printProgressState(
                    BossStatusResponse.from(boss.getStatus()),
                    player.getName().getValue(),
                    PlayerStatusResponse.from(player.getStatus())
            );
        }
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

    private AttackCommand getAttackCommand() {
        final String input = inputView.selectAttackCommand();
        return AttackCommand.from(input);
    }

    private void attackPlayer(final AttackCommand attackCommand, final Player player, final Boss boss) {
        if (attackCommand.isPhysicalAttack()) {
            player.attackPhysical(boss);
            outputView.printPhysicalAttackMessage();
            return;
        }

        if (player.isDeficientManaPoint()) {
            throw new IllegalArgumentException("MP 가 부족해 공격할 수 없습니다.");
        }
        player.attackMagic(boss);
        outputView.printMagicalAttackMessage();
    }

    private void attackBoss(final DamageGenerator damageGenerator) {
        final int damage = damageGenerator.getDamage();
        outputView.printBossAttackMessage(damage);
    }
}
