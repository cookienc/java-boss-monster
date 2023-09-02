package bossmonster.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class DamageGenerator {

    private final Random random;

    public DamageGenerator() throws NoSuchAlgorithmException {
        random = SecureRandom.getInstanceStrong();
    }

    public int getDamage() {
        return random.nextInt(0, 20);
    }
}
