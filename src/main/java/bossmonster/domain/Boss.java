package bossmonster.domain;

import bossmonster.domain.vo.HealthPoint;

public class Boss {

    private final HealthPoint healthPoint;

    public Boss(final HealthPoint healthPoint) {
        this.healthPoint = healthPoint;
    }

    public HealthPoint getHealthPoint() {
        return healthPoint;
    }
}
