import java.util.ArrayList;

public class vehiculos {
    String categorias;
    int cantidad;
    ArrayList<String> combustibles;
    ArrayList<Double> porcentaje;

    vehiculos(String categorias, int cantidad, ArrayList<String> combustible, ArrayList<Double> porcentaje) {
        this.categorias = categorias;
        this.cantidad = cantidad;
        this.combustibles = combustible;
        this.porcentaje = porcentaje;
    }

    public void calEmiciones() {
        System.out.println("categorias: " + categorias);
        for(int i = 0; i < combustibles.size(); i++) {
            String combustible = combustibles.get(i);
            double porcentaje = this.porcentaje.get(i);
            int canPorcComb = (int) (cantidad * porcentaje / 100);
        };
        System.out.println();
    }
}
