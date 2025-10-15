package Units;

import Enums.UnitsEnum;

public class Unit {
    private double def;
    private double damBase;
    private double life = 100;
    private UnitsEnum unitType;
    private UnitsEnum disAdvantage;


    public Unit(double def, double damBase, UnitsEnum unitType, UnitsEnum disAdvantage) {
        this.def = def;
        this.damBase = damBase;
        this.unitType = unitType;
        this.disAdvantage = disAdvantage;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getDamBase() {
        return damBase;
    }

    public void setDamBase(double damBase) {
        this.damBase = damBase;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public UnitsEnum getDisAdvantage() {
        return disAdvantage;
    }

    public void setDisAdvantage(UnitsEnum disAdvantage) {
        this.disAdvantage = disAdvantage;
    }

    public UnitsEnum getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitsEnum unitType) {
        this.unitType = unitType;
    }
}
