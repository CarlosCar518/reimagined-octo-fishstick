package vehiculos;

import Interfaces.SistemaTarifario;

abstract public class Vehicle implements SistemaTarifario {
    private int pricePerStation;
    private String route;


    public Vehicle() {
    }

    public Vehicle(String route, int pricePerStation) {
        this.route = route;
        this.pricePerStation = pricePerStation;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPricePerStation() {
        return pricePerStation;
    }

    public void setPricePerStation(int pricePerStation) {
        this.pricePerStation = pricePerStation;
    }

    public int calcPrice(int numStations) {
        int total = pricePerStation * numStations;
        System.out.printf("Precio %d\n", total);
        return total;
    }

    public void showRoute() {
        System.out.println("ruta: " + route);
    }
}
