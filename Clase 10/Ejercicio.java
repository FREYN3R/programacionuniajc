import java.util.*;
 
public class Ejercicio {
    public static void main(String[] args) {
 
        Stack<String> nombre = new Stack<String>();
 
        nombre.push("Adam");
        nombre.push("Sarah");
        nombre.push("Malcon");
 
        System.out.println(nombre);
 
        String[] iniciales = new String[nombre.size()];
 
        nombre.toArray(iniciales);
       
        for (int i = 0; i < iniciales.length; i++) {
            iniciales[i]= String.valueOf(iniciales[i].substring(0, 1));
        }
 
        Arrays.sort(iniciales);
        System.out.println(Arrays.toString(iniciales));
 
    }
} 
