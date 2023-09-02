package bossmonster.domain;

import bossmonster.domain.vo.HealthPoint;
import bossmonster.domain.vo.ManaPoint;
import bossmonster.domain.vo.Name;

public class Player {

    private final Name name;
    private final HealthPoint healthPoint;
    private final ManaPoint manaPoint;

    public Player(final Name name, final HealthPoint healthPoint, final ManaPoint manaPoint) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.manaPoint = manaPoint;
    }

    public Name getName() {
        return name;
    }

    public HealthPoint getHealthPoint() {
        return healthPoint;
    }

    public ManaPoint getManaPoint() {
        return manaPoint;
    }
}
