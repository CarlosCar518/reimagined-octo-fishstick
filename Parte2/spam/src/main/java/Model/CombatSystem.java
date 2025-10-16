package Model;

import Units.Unit;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.concurrent.ThreadLocalRandom;

public class CombatSystem {
    private Unit blueUnit;
    private Unit redUnit;

    public CombatSystem() {
    }

    private void setUnits(Unit blueUnit, Unit redUnit){
        this.blueUnit = blueUnit;
        this.redUnit = redUnit;
    }

    public boolean fight(Unit blueUnit, Unit redUnit){
        setUnits(blueUnit, redUnit);
        boolean whoAttacks = true;

        while (blueUnit.getLife() > 0 && redUnit.getLife() > 0)
        {
            double variableDam = getVariableDam(whoAttacks);
            if (whoAttacks){
                double totalDam = Math.max(0,(blueUnit.getDamBase()*variableDam) - redUnit.getDef());
                redUnit.setLife(redUnit.getLife() - totalDam);
                whoAttacks = false;
                continue;
            }

            double totalDam = Math.max(0,(redUnit.getDamBase()*variableDam) - blueUnit.getDef());
            blueUnit.setLife(blueUnit.getLife() - totalDam);
            whoAttacks = true;
        }
        return blueUnit.getLife() <= 0;
    }

    //true for blue
    private int getRelation(){
        if (blueUnit.getUnitType() == redUnit.getDisAdvantage())
            return 0;
        if (blueUnit.getDisAdvantage() == redUnit.getUnitType())
            return 1;
        return 2;
    }

    private double getVariableDam(boolean whoAttacks){
        switch (getRelation()) {
            case 0:
                return (whoAttacks) ? 1 : 0.5; // azul gana
            case 1:
                return (whoAttacks) ? 0.5 : 1; // rojo gana
            default: // Neutro
                NormalDistribution normalDistribution = new NormalDistribution(0.75,0.1);
                double pLower = normalDistribution.cumulativeProbability(0.5);
                double pUpper = normalDistribution.cumulativeProbability(1);
                double p = ThreadLocalRandom.current().nextDouble(pLower, pUpper);
                return normalDistribution.inverseCumulativeProbability(p);
        }
    }
}
