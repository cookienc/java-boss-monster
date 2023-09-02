package bossmonster.view;

public class StatusDto {

    private final String healthPoint;
    private final String manaPoint;

    public StatusDto(final String healthPoint, final String manaPoint) {
        this.healthPoint = healthPoint;
        this.manaPoint = manaPoint;
    }

    public String getHealthPoint() {
        return healthPoint;
    }

    public String getManaPoint() {
        return manaPoint;
    }
}
