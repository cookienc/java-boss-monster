package bossmonster;

import bossmonster.controller.GameController;
import bossmonster.domain.DamageGenerator;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        final GameController gameController = new GameController(new InputView(), new OutputView());
        gameController.playGame(new DamageGenerator());
    }
}
