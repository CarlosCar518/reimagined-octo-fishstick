package Units;

import Enums.UnitsEnum;

public class Infantry extends Unit{
    public Infantry() {
        super(5, 10, UnitsEnum.INFANTRY, UnitsEnum.ARCHERS);
    }
}
