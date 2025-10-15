package vehiculos;

public class SubWay extends Vehicle {
    public SubWay(String route) {
        int setPrice = 3000;
        super(route, 3000);
    }

    public int calcPrice(){
        return getPricePerStation();
    }
}
