public class Eje2 {
    public static void main(String[] args) {
        Pila<String> p = new Pila<>();
        p.insertar("A");
        p.insertar("B");
        p.insertar("C");

        System.out.println("Elementos de la pila:");
        p.mostrarPila();
    }
}