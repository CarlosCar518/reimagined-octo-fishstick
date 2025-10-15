package DAO;

import Units.Unit;

import java.util.ArrayList;

public class ArmiesStacks {
    int armySize;
    ArrayList<Unit> blueArmyStack;
    ArrayList<Unit> redArmyStack;

    public ArmiesStacks(int armySize) {
        this.blueArmyStack = new ArrayList<>();
        this.redArmyStack = new ArrayList<>();
        this.armySize = armySize;
    }
}
