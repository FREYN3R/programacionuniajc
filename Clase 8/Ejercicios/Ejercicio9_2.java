import java.util.Stack;

// Clase que representa una pila de cadenas de caracteres
class PilaCaracteres {
    private Stack<String> pila = new Stack<>(); // Se utiliza una pila de la clase Stack de Java

    // Método para insertar un elemento en la pila
    public void insertar(String dato) {
        pila.push(dato); // Agrega el dato en la cima de la pila
    }

    // Método para quitar (eliminar y devolver) el elemento en la cima de la pila
    public String quitar() {
        return pila.isEmpty() ? null : pila.pop(); // Si la pila está vacía, devuelve null; si no, quita el último elemento
    }

    // Método para verificar si la pila está vacía
    public boolean pilaVacia() {
        return pila.isEmpty(); // Devuelve true si la pila no tiene elementos, false en caso contrario
    }

    // Método para mostrar los elementos de la pila sin alterarla
    public void mostrarPila() {
        Stack<String> aux = new Stack<>(); // Se crea una pila auxiliar para preservar los datos originales

        // Se extraen los elementos de la pila original y se imprimen
        while (!pilaVacia()) {
            String elem = quitar(); // Se extrae el elemento de la cima
            System.out.print(elem + " "); // Se imprime el elemento
            aux.push(elem); // Se almacena en la pila auxiliar para restaurarlo luego
        }

        // Se restauran los elementos a la pila original
        while (!aux.isEmpty()) {
            insertar(aux.pop()); // Se extrae de la pila auxiliar y se vuelve a insertar en la original
        }

        System.out.println(); // Se agrega un salto de línea para mejor visualización
    }
}

// Clase principal que contiene el método main
public class Ejercicio9_2 {
    public static void main(String[] args) {
        // Se crea una instancia de la pila de caracteres
        PilaCaracteres pila = new PilaCaracteres();

        // Se insertan algunos elementos en la pila
        pila.insertar("X");
        pila.insertar("Y");
        pila.insertar("Z");

        // Se imprime la pila sin modificarla
        System.out.println("Elementos de la pila:");
        pila.mostrarPila();
    }
}
