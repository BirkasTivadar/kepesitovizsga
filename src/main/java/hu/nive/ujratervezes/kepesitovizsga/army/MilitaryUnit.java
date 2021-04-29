package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {

    private int hitPoints;

    private int damageOfUnit;

    private Boolean armoured;

    public MilitaryUnit(int hitPoints, int damageOfUnit, Boolean armoured) {
        this.hitPoints = hitPoints;
        this.damageOfUnit = damageOfUnit;
        this.armoured = armoured;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDamageOfUnit() {
        return damageOfUnit;
    }

    public int doDamage() {
        return damageOfUnit;
    }

    public void sufferDamage(int damage) {
        hitPoints -= armoured ? damage / 2 : damage;
    }
}