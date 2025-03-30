import java.util.Stack;

class NotacionPostfija {
    
    // Método para obtener la precedencia de los operadores
    public static int precedencia(char operador) {
        switch (operador) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    // Método que convierte una expresión infija a postfija
    public static String infijaAPostfija(String expresion) {
        Stack<Character> pila = new Stack<>();
        StringBuilder resultado = new StringBuilder();

        // Se recorre cada carácter de la expresión
        for (char c : expresion.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { 
                resultado.append(c); // Si es un operando, se agrega al resultado
            } else if (c == '(') {
                pila.push(c); // Si es un paréntesis de apertura, se agrega a la pila
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    resultado.append(pila.pop()); // Se extraen operadores hasta '('
                }
                pila.pop(); // Se elimina el '('
            } else { 
                while (!pila.isEmpty() && precedencia(pila.peek()) >= precedencia(c)) {
                    resultado.append(pila.pop()); // Se extraen operadores de mayor o igual precedencia
                }
                pila.push(c); // Se inserta el operador actual en la pila
            }
        }

        // Se vacía la pila en el resultado final
        while (!pila.isEmpty()) {
            resultado.append(pila.pop());
        }

        return resultado.toString();
    }
}

// Clase principal para probar la conversión
public class Ejercicio9_3 {
    public static void main(String[] args) {
        String expresion = "(x-y)/(z+w)=(z+y)^x";
        System.out.println("Postfija: " + NotacionPostfija.infijaAPostfija(expresion));
    }
}
