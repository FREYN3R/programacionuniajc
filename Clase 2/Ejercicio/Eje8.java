package Ejercicio;

import java.util.Scanner;

public class Eje8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Arreglo para almacenar los 30 números
        int[] numeros = new int[30];
        
        // Solicitar los 30 números
        System.out.println("Ingrese 30 números:");
        for (int i = 0; i < 30; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        
        // Encontrar el número mayor y menor
        int mayor = numeros[0];
        int menor = numeros[0];
        
        for (int num : numeros) {
            if (num > mayor) {
                mayor = num;
            }
            if (num < menor) {
                menor = num;
            }
        }
        
        // Contar las repeticiones del mayor y menor
        int repeticionesMayor = 0;
        int repeticionesMenor = 0;
        
        for (int num : numeros) {
            if (num == mayor) {
                repeticionesMayor++;
            }
            if (num == menor) {
                repeticionesMenor++;
            }
        }
        
        // Mostrar resultados
        System.out.println("\nEl número mayor es: " + mayor);
        System.out.println("Se repite " + repeticionesMayor + " veces.");
        
        System.out.println("\nEl número menor es: " + menor);
        System.out.println("Se repite " + repeticionesMenor + " veces.");
        
        scanner.close();
    }
}