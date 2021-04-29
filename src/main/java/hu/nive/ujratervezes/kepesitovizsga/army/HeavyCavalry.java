package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {

    private boolean firstAttack = true;

    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        if (firstAttack) {
            int result = getDamageOfUnit() * 3;
            firstAttack = false;
            return result;
        }
        return super.doDamage();
    }

}
