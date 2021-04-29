package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Army {

    private List<MilitaryUnit> militaryUnits = new ArrayList<>();


    public int getArmySize() {
        return militaryUnits.size();
    }

    public void addUnit(MilitaryUnit militaryUnit) {
        militaryUnits.add(militaryUnit);
    }

    public int getArmyDamage() {
        return militaryUnits.stream().mapToInt(MilitaryUnit::doDamage).sum();
    }

    public void damageAll(int damage) {
        militaryUnits.forEach(e -> e.sufferDamage(damage));
        militaryUnits = militaryUnits.stream().filter(e -> e.getHitPoints() > 25).collect(Collectors.toList());
    }

}
