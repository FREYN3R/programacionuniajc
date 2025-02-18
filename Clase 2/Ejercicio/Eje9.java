package Ejercicio;

import java.util.Scanner;

public class Eje9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el tamaño del arreglo (N)
        System.out.print("Ingrese el tamaño del arreglo (N): ");
        int n = scanner.nextInt();
        
        // Crear el arreglo de tamaño N
        int[] arreglo = new int[n];
        
        // Llenar el arreglo con números ingresados por el usuario
        System.out.println("\nIngrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }
        
        // Solicitar el número a buscar
        System.out.print("\nIngrese el número a buscar: ");
        int numeroBuscado = scanner.nextInt();
        
        // Contar las repeticiones del número en el arreglo
        int repeticiones = 0;
        for (int num : arreglo) {
            if (num == numeroBuscado) {
                repeticiones++;
            }
        }
        
        // Mostrar el resultado
        System.out.println("\nEl número " + numeroBuscado + " se repite " + repeticiones + " veces.");
        
        scanner.close();
    }
}