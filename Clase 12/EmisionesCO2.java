import java.util.ArrayList;
import java.util.List;

public class EmisionesCO2 {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Camiones Livianos", 400000,
            new ArrayList<>(List.of("Gasolina", "Diesel", "Gas")),
            new ArrayList<>(List.of(30.0, 40.0, 30.0))
        ));
        vehiculos.add(new Vehiculo("Camiones Medianos", 280000,
            new ArrayList<>(List.of("Gasolina", "Diesel", "Gas")),
            new ArrayList<>(List.of(25.0, 50.0, 25.0))
        ));
        vehiculos.add(new Vehiculo("Camiones Pesados", 380000,
            new ArrayList<>(List.of("Gasolina", "Diesel", "Gas")),
            new ArrayList<>(List.of(10.0, 80.0, 10.0))
        ));
        vehiculos.add(new Vehiculo("Tractocamiones", 1150000,
            new ArrayList<>(List.of("Gasolina", "Diesel", "Gas")),
            new ArrayList<>(List.of(5.0, 90.0, 5.0))
        ));
        vehiculos.add(new Vehiculo("Volquetas", 936000,
            new ArrayList<>(List.of("Gasolina", "Diesel", "Gas")),
            new ArrayList<>(List.of(40.0, 40.0, 20.0))
        ));

        for (Vehiculo v : vehiculos) {
            v.calcularCO2();
        }
    }
}