// Clase que representa un nodo de la lista doblemente enlazada
class Nodo {
    int dato;
    Nodo siguiente;
    Nodo anterior;

    // Constructor del nodo
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

// Clase que implementa una bicola con lista doblemente enlazada
class Bicola {
    private Nodo frente; // Apunta al primer elemento de la bicola
    private Nodo fin; // Apunta al último elemento de la bicola

    // Constructor para inicializar la bicola vacía
    public Bicola() {
        this.frente = null;
        this.fin = null;
    }

    // Método para verificar si la bicola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Método para insertar un elemento al frente de la bicola
    public void insertarFrente(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            nuevo.siguiente = frente;
            frente.anterior = nuevo;
            frente = nuevo;
        }
    }

    // Método para insertar un elemento al final de la bicola
    public void insertarFin(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            nuevo.anterior = fin;
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    // Método para eliminar un elemento del frente de la bicola
    public int eliminarFrente() {
        if (estaVacia()) {
            System.out.println("Error: La bicola está vacía.");
            return -1;
        }
        int dato = frente.dato;
        if (frente == fin) { // Solo hay un elemento
            frente = fin = null;
        } else {
            frente = frente.siguiente;
            frente.anterior = null;
        }
        return dato;
    }

    // Método para eliminar un elemento del final de la bicola
    public int eliminarFin() {
        if (estaVacia()) {
            System.out.println("Error: La bicola está vacía.");
            return -1;
        }
        int dato = fin.dato;
        if (frente == fin) { // Solo hay un elemento
            frente = fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return dato;
    }

    // Método para mostrar los elementos de la bicola desde el frente hasta el fin
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La bicola está vacía.");
            return;
        }
        Nodo actual = frente;
        System.out.print("Bicola: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

// Clase principal para probar la bicola
public class Ejercicio10_3 {
    public static void main(String[] args) {
        Bicola bicola = new Bicola();

        // Insertar elementos por ambos extremos
        bicola.insertarFrente(10);
        bicola.insertarFrente(20);
        bicola.insertarFin(30);
        bicola.insertarFin(40);
        
        // Mostrar la bicola actual
        bicola.mostrar(); // Esperado: 20 10 30 40

        // Eliminar elementos por ambos extremos
        System.out.println("Elemento eliminado del frente: " + bicola.eliminarFrente()); // 20
        System.out.println("Elemento eliminado del fin: " + bicola.eliminarFin()); // 40

        // Mostrar la bicola después de eliminar
        bicola.mostrar(); // Esperado: 10 30
    }
}
