public class Eje1 {

    public static void main(String[] args) {
         
            Pila p = new Pila();

            int x = 4, y;
            p.insertar(x); //Se inserta x en la pila 

            System.out.println("n " + p.cimaPila()); //Imprime n + 4

            y = p.quitar(); //Elimina el elemento de la cima de la pila
            p.insertar(32); //Se inserta 32 en la pila
            p.insertar(p.quitar()); //Elimina el elemento de la cima de la pila y lo vuelve a inserta 
            
            do {
                System.out.println("n " + p.quitar()); // Imprime n + 32
            } while (!p.pilaVacia());
        }
}


