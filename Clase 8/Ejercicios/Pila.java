import java.util.ArrayList;

public class Pila {
    private ArrayList<Integer> elementos;

    // Constructor: inicializa la pila vacía
    public Pila() {
        elementos = new ArrayList<>();
    }

    // Inserta un elemento en la cima de la pila
    public void insertar(int x) {
        elementos.add(x);
    }

    // Quita y devuelve el elemento en la cima de la pila
    public int quitar() {
        if (pilaVacia()) {
            throw new IllegalStateException("La pila está vacía, no se puede quitar un elemento.");
        }
        int elemento = elementos.remove(elementos.size() - 1);
        return elemento;
    }

    // Devuelve el elemento en la cima de la pila sin quitarlo
    public int cimaPila() {
        if (pilaVacia()) {
            throw new IllegalStateException("La pila está vacía, no hay cima.");
        }
        return elementos.get(elementos.size() - 1);
    }

    // Verifica si la pila está vacía
    public boolean pilaVacia() {
        return elementos.isEmpty();
    }
}