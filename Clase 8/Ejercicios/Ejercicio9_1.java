import java.util.Stack;

class PilaEnteros {
    private Stack<Integer> pila = new Stack<>();

    // Método para insertar un elemento en la pila
    public void insertar(int dato) {
        pila.push(dato);
    }

    // Método para quitar (eliminar y devolver) el elemento en la cima de la pila
    public int quitar() {
        return pila.isEmpty() ? -1 : pila.pop(); // Devuelve -1 si la pila está vacía
    }

    // Método para obtener el elemento en la cima sin quitarlo
    public int cimaPila() {
        return pila.isEmpty() ? -1 : pila.peek();
    }

    // Método para verificar si la pila está vacía
    public boolean pilaVacia() {
        return pila.isEmpty();
    }
}

public class Ejercicio9_1 {
    public static void main(String[] args) {
        PilaEnteros p = new PilaEnteros();
        int x = 4, y;

        p.insertar(x); // Se inserta el número 4 en la pila
        System.out.println("\n" + p.cimaPila()); // Imprime el número en la cima (4)
        y = p.quitar(); // Se elimina y guarda en y el valor 4
        p.insertar(32); // Se inserta 32 en la pila
        p.insertar(p.quitar()); // Se extrae y reinserta 32

        // Se imprimen los elementos de la pila hasta que esté vacía
        do {
            System.out.println("\n" + p.quitar()); // Imprime 32
        } while (!p.pilaVacia());
    }
}