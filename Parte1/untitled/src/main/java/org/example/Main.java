package org.example;

import Interfaces.SistemaTarifario;
import vehiculos.Bus;
import vehiculos.Ferry;
import vehiculos.SubWay;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<SistemaTarifario> vehiclesList = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    static void main() {
        mainLoop();
    }

    static void mainLoop() {
        int result = 0;
        while (true){
            System.out.println("Bienvenido al sistema tarifario de Hyrule.\nIngrese 1 para añadir un tipo de vehiculo." +
                    "\nIngrese 2 para cobrar\nIngrese 3 para ver la ruta de los vehiculos\nIngrese 0 para terminar.");
            try {
                result = in.nextInt();
                switch (result){
                    case 1:
                        createVehicle();
                        break;
                    case 2:
                        chargeAmount();
                        break;
                    case 3:
                        showVehicles();
                        break;
                    case 0:
                        return;
                    default:
                        throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("SOLO ESCRIBA LOS NUMEROS INDICADOS\n");
                in.nextLine();
            }
        }
    }

    static void createVehicle(){
        System.out.println("Ingrese la ruta del vehiculo");
        String ruta = in.next();
        while (true){
            try {
                System.out.println("Ingrese 0 para Ferry.\nIngrese 1 para Bus.\nIngrese 2 para Metro");
                int selection = in.nextInt();
                SistemaTarifario result = switch (selection){
                    case 0 -> new Ferry(ruta);
                    case 1 -> new Bus(ruta);
                    case 2 -> new SubWay(ruta);
                    default -> throw new InputMismatchException();
                };
                vehiclesList.add(result);
                return;
            }catch (InputMismatchException e){
                System.out.println("Porfavor, solo ingrese numeros y los valores deseados\n");
                in.nextLine();
            }
        }
    }

    static void chargeAmount(){
        if (!showVehicles())
            return;
        SistemaTarifario selec = null;
        int stations = 0;
        while (true) {
            try {
                System.out.println("Seleccione el vehiculo del cliente.\n0 ferry\n1 bus\n2 metro");
                int i = in.nextInt();
                selec = switch (i){
                    case 0-> new Ferry("x");
                    case 1-> new Bus("x");
                    case 2-> new SubWay("X");
                    default -> throw new  InputMismatchException();
                    };
                System.out.println("Ingrese el numero de estaciones que va a recorrer");
                stations = in.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Solo escriba los numeros indicados");
                in.nextLine();
                continue;
            }
            break;
        }
        boolean isIn = false;
        for (SistemaTarifario v: vehiclesList){
            if (v.getClass() == selec.getClass()){
                isIn = true;
                break;
            }
        }

        if (!isIn){
            System.out.println("Vehiculo no en la lista. Porfavor Añadalo\n");
            return;
        }
        selec.calcPrice(stations);
    }

    static boolean showVehicles(){
        if (vehiclesList.isEmpty()){
            System.out.println("No hay vehiculos. Nada que mostrar");
            return false;
        }
        int i = 0;
        for (SistemaTarifario veh: vehiclesList){
            System.out.printf("Vehiculo numero %d.\n%s con ",i++,veh.getClass().getSimpleName());
            veh.showRoute();
            System.out.println();
        }
        return true;
    }
}
