package bossmonster.view.dto;

import bossmonster.domain.vo.Status;

public class BossStatusResponse {

    private final int currentHealthPoint;
    private final int originHealthPoint;

    private BossStatusResponse(final int currentHealthPoint, final int originHealthPoint) {
        this.currentHealthPoint = currentHealthPoint;
        this.originHealthPoint = originHealthPoint;
    }

    public static BossStatusResponse from(final Status status) {
        return new BossStatusResponse(status.getCurrentHealthPoint().getValue(), status.getOrigineHealthPoint().getValue());
    }

    public int getCurrentHealthPoint() {
        return currentHealthPoint;
    }

    public int getOriginHealthPoint() {
        return originHealthPoint;
    }
}
