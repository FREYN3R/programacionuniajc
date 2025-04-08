import java.util.Stack;
 
public class CuatroLetras {
    public static void main(String[] args) {
        Stack<String> cadena = new Stack<>();
        cadena.addAll(java.util.Arrays.asList("Canguro", "Oso", "Zorro"));
       
        for (int i = 0; i < cadena.size(); i++) {
            if (cadena.elementAt(i).length() <= 4) {
                System.out.println(cadena.elementAt(i));
            }
        }
    }
}