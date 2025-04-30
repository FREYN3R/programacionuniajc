import java.util.ArrayList;

class Vehiculo {
    String categoria;
    int cantidad;
    ArrayList<String> combustibles;
    ArrayList<Double> porcentajes;

    Vehiculo(String categoria, int cantidad, ArrayList<String> combustibles, ArrayList<Double> porcentajes) {
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.combustibles = combustibles;
        this.porcentajes = porcentajes;
    }

    public void calcularCO2() {
        System.out.println("Categoría: " + categoria);
        for (int i = 0; i < combustibles.size(); i++) {
            String combustible = combustibles.get(i);
            double porcentaje = porcentajes.get(i);
            int cantidadPorCombustible = (int)(cantidad * (porcentaje / 100.0));
            double factorEmision = obtenerFactorCO2(combustible);
            double totalCO2 = cantidadPorCombustible * factorEmision;

            System.out.println("  " + combustible + ": " + cantidadPorCombustible +
                " vehículos → " + String.format("%.2f", totalCO2) + " kg CO₂");
        }
        System.out.println();
    }

    private double obtenerFactorCO2(String combustible) {
        switch (combustible.toLowerCase()) {
            case "gasolina": return 2310; // kg CO2 por vehículo al año
            case "diesel": return 2680;
            case "gas": return 1510;
            default: return 0;
        }
    }
}