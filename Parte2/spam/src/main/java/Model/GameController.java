package Model;

import DAO.ArmiesStacks;
import Enums.UnitsEnum;
import Units.*;

import java.util.HashMap;
import java.util.function.Supplier;

public class GameController {
    CombatSystem combatSystem;
    ArmiesStacks armiesStacks;

    HashMap<UnitsEnum, Supplier<Unit>> generator = new HashMap<>();

    public GameController() {
        combatSystem = new CombatSystem();
        armiesStacks = new ArmiesStacks();

        generator.put(UnitsEnum.INFANTRY, Infantry::new);
        generator.put(UnitsEnum.SPEARS, Spears::new);
        generator.put(UnitsEnum.ARCHERS, Archers::new);
        generator.put(UnitsEnum.CAVALRY, Cavalry::new);
    }

    public UnitsEnum[] parseArmyFromStrings(String[] armyStrings) {
        UnitsEnum[] army = new UnitsEnum[armyStrings.length];
        for (int i = 0; i < armyStrings.length; i++) {
            army[i] = UnitsEnum.valueOf(armyStrings[i].toUpperCase());
        }
        return army;
    }

    public void setArmies(int size, UnitsEnum[] blueArmy, UnitsEnum[] redArmy){
        for (UnitsEnum i : blueArmy){
            armiesStacks.blueArmyStack.add(generator.get(i).get());
        }

        for (UnitsEnum i : redArmy){
            armiesStacks.redArmyStack.add(generator.get(i).get());
        }

        armiesStacks.armySize = size;
    }

    public boolean combat(){
        while (!armiesStacks.blueArmyStack.isEmpty() && !armiesStacks.redArmyStack.isEmpty()){
            boolean result = combatSystem.fight(armiesStacks.blueArmyStack.getFirst(), armiesStacks.redArmyStack.getFirst());
            if (result){
                armiesStacks.redArmyStack.removeFirst();
                continue;
            }
            armiesStacks.blueArmyStack.removeFirst();
        }
        boolean foo = armiesStacks.blueArmyStack.isEmpty();
        armiesStacks.restart();
        return foo;
    }
}
