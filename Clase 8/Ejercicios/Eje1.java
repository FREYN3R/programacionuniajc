import java.util.Stack;
public class Eje1{

    class Pila {
        private Stack<Integer> stack = new Stack<>();
    
        public void insertar(int elemento) {
            stack.push(elemento);
        }
    
        public int quitar() {
            return stack.pop();
        }
    
        public int cimaPila() {
            return stack.peek();
        }
    
        public boolean pilaVacia() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
         
        Pila p = new Pila();
        int x = 4, y;
        p.insertar(x);
        System.out.println("\n " + p.cimaPila());
        y = p.quitar();
        p.insertar(32);
        p.insertar(p.quitar());
        do {
            System.out.println("\n " + p.quitar());
        } while (!p.pilaVacia());
    }

}

