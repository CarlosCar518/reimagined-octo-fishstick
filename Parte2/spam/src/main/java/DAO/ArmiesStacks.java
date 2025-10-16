package DAO;

import Units.Unit;

import java.util.ArrayList;

public class ArmiesStacks {
    public int armySize;
    public ArrayList<Unit> blueArmyStack;
    public ArrayList<Unit> redArmyStack;

    public ArmiesStacks() {
        this.blueArmyStack = new ArrayList<>();
        this.redArmyStack = new ArrayList<>();
    }


}
