package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {

    private boolean existShield = true;


    public Swordsman(Boolean armour) {
        super(100, 10, armour);
    }

    @Override
    public void sufferDamage(int damage) {
        if (existShield) {
            existShield = false;
            return;
        }
        super.sufferDamage(damage);
    }
}
