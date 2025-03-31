
class ColaCircular {
    private int[] cola;  // Arreglo para almacenar los elementos
    private int capacidad;  // Tamaño máximo de la cola
    private int frente;  // Índice del primer elemento
    private int fin;  // Índice donde se insertará el próximo elemento
    private int numElementos;  // Contador de elementos en la cola

    // Constructor que inicializa la cola con una capacidad dada
    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.cola = new int[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.numElementos = 0;
    }

    // Método para verificar si la cola está llena
    public boolean estaLlena() {
        return numElementos == capacidad;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return numElementos == 0;
    }

    // Método para insertar un elemento en la cola
    public void encolar(int dato) {
        if (estaLlena()) {
            System.out.println("Error: La cola está llena.");
            return;
        }
        // Se avanza "fin" de manera circular
        fin = (fin + 1) % capacidad;
        cola[fin] = dato;
        numElementos++;  // Se incrementa el contador
    }

    // Método para eliminar un elemento de la cola
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("Error: La cola está vacía.");
            return -1;  // Se devuelve un valor indicativo de error
        }
        int dato = cola[frente];  // Se obtiene el elemento del frente
        // Se avanza "frente" de manera circular
        frente = (frente + 1) % capacidad;
        numElementos--;  // Se decrementa el contador
        return dato;
    }

    // Método para obtener el elemento en el frente sin eliminarlo
    public int obtenerFrente() {
        if (estaVacia()) {
            System.out.println("Error: La cola está vacía.");
            return -1;
        }
        return cola[frente];
    }

    // Método para obtener el número de elementos en la cola
    public int tamano() {
        return numElementos;
    }

    // Método para mostrar los elementos de la cola
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.print("Elementos en la cola: ");
        for (int i = 0, index = frente; i < numElementos; i++) {
            System.out.print(cola[index] + " ");
            index = (index + 1) % capacidad;  // Se avanza circularmente
        }
        System.out.println();
    }
}

// Clase principal para probar la cola circular
public class Ejercicio10_2 {
    public static void main(String[] args) {
        ColaCircular cola = new ColaCircular(5); // Se crea una cola de capacidad 5

        // Se insertan elementos en la cola
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.encolar(40);
        cola.encolar(50);
        
        // Se intenta insertar un elemento en una cola llena
        cola.encolar(60); // Debería mostrar un error

        // Se muestra el estado de la cola
        cola.mostrarCola();

        // Se eliminan algunos elementos
        System.out.println("Elemento desencolado: " + cola.desencolar());
        System.out.println("Elemento desencolado: " + cola.desencolar());

        // Se muestran los elementos restantes
        cola.mostrarCola();

        // Se insertan nuevos elementos en la cola circular
        cola.encolar(60);
        cola.encolar(70);
        cola.mostrarCola();
    }
}
