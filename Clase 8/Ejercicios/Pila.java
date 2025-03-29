import java.util.ArrayList;

public class Pila<T> { // T es un tipo genérico
    private ArrayList<T> elementos;

    // Constructor
    public Pila() {
        elementos = new ArrayList<>();
    }

    // Inserta un elemento en la cima de la pila
    public void insertar(T x) {
        elementos.add(x);
    }

    // Quita y devuelve el elemento en la cima de la pila
    public T quitar() {
        if (pilaVacia()) {
            throw new IllegalStateException("La pila está vacía, no se puede quitar un elemento.");
        }
        return elementos.remove(elementos.size() - 1);
    }

    // Devuelve el elemento en la cima de la pila sin quitarlo
    public T cimaPila() {
        if (pilaVacia()) {
            throw new IllegalStateException("La pila está vacía, no hay cima.");
        }
        return elementos.get(elementos.size() - 1);
    }

    // Verifica si la pila está vacía
    public boolean pilaVacia() {
        return elementos.isEmpty();
    }

    // Método para mostrar los elementos de la pila
    public void mostrarPila() {
        Pila<T> aux = new Pila<>();

        // Transferir y mostrar
        while (!pilaVacia()) {
            T elemento = quitar();
            System.out.println(elemento);
            aux.insertar(elemento);
        }

        // Restaurar la pila original
        while (!aux.pilaVacia()) {
            insertar(aux.quitar());
        }
    }
}