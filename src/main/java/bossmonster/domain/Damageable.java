package bossmonster.domain;

import bossmonster.domain.vo.Damage;

public abstract class Damageable {

    protected abstract void minusHealthPoint(final Damage attackDamage);
}
