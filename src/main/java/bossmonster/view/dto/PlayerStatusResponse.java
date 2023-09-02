package bossmonster.view.dto;

import bossmonster.domain.vo.Status;

public class PlayerStatusResponse {

    private final int currentHealthPoint;
    private final int originHealthPoint;
    private final int currentManaPoint;
    private final int originManaPoint;

    private PlayerStatusResponse(final int currentHealthPoint, final int originHealthPoint, final int currentManaPoint, final int originManaPoint) {
        this.currentHealthPoint = currentHealthPoint;
        this.originHealthPoint = originHealthPoint;
        this.currentManaPoint = currentManaPoint;
        this.originManaPoint = originManaPoint;
    }

    public static PlayerStatusResponse from(final Status status) {
        return new PlayerStatusResponse(
                status.getCurrentHealthPoint().getValue(),
                status.getOrigineHealthPoint().getValue(),
                status.getCurrentManaPoint().getValue(),
                status.getOriginManaPoint().getValue()
        );
    }

    public int getCurrentHealthPoint() {
        return currentHealthPoint;
    }

    public int getOriginHealthPoint() {
        return originHealthPoint;
    }

    public int getCurrentManaPoint() {
        return currentManaPoint;
    }

    public int getOriginManaPoint() {
        return originManaPoint;
    }
}
