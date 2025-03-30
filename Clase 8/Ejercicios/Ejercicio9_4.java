import java.util.Stack;

// Clase que maneja la pila de números reales
class PilaNumeros {
    private Stack<Double> pila = new Stack<>();

    // Método para insertar un número en la pila
    public void insertar(double numero) {
        pila.push(numero);
    }

    // Método para quitar un número de la pila
    public double quitar() {
        return pila.isEmpty() ? Double.NaN : pila.pop(); // Devuelve NaN si la pila está vacía
    }

    // Método para verificar si la pila está vacía
    public boolean pilaVacia() {
        return pila.isEmpty();
    }

    // Método para imprimir la pila extrayendo los elementos
    public void imprimirYVaciar() {
        while (!pilaVacia()) {
            System.out.print(quitar() + " ");
        }
        System.out.println(); // Salto de línea
    }
}

// Clase principal para probar la funcionalidad
public class Ejercicio9_4 {
    public static void main(String[] args) {
        double[] numeros = {1.2, 3.4, 5.6, 7.8, 9.1, 2.3, 4.5, 6.7, 8.9, 10.0};
        PilaNumeros pila = new PilaNumeros();

        // Se imprime la secuencia original
        System.out.println("Secuencia original:");
        for (double num : numeros) {
            System.out.print(num + " ");
            pila.insertar(num); // Se agregan los números a la pila
        }

        // Se imprime la pila extrayendo los elementos
        System.out.println("\nElementos en la pila (orden LIFO):");
        pila.imprimirYVaciar();
    }
}
