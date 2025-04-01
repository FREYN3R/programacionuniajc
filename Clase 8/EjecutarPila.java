import java.util.Stack;

public class EjecutarPila {

    public static void main(String[] args) {
        
        //Creacion de la estructura Stack(Pila)
        Stack<String> nombres = new Stack<>();

        //Verificar si la pila esta vacia
        System.out.println(nombres.empty()); 

        //Insertar elementos en la pila
        nombres.push("Pedro");
        nombres.push("Juan");
        nombres.push("Maria");
        nombres.push("Camila");
        nombres.push("Daniel");

        //Imprimir la pila
        System.out.println(nombres); //[Pedro, Juan, Maria, Camila, Daniel]

        //Mostrar quien esta en el tope de la fila sin removerlo
        System.out.println(nombres.peek()); //Daniel

        //Buscar un elemento dentro de la pila
        System.out.println(nombres.search("Camila")); // 2 --> 2-1 = 1

        //Retirar un elemento de la pila
        System.out.println(nombres.pop());

        //Imprimir la pila retirada
        System.out.println(nombres); //[Pedro, Juan, Maria, Camila]

        //Verificar el tamaño de la pila
        System.out.println(nombres.size()); //4

    }

}