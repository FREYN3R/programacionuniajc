package Ejercicios;

import java.util.Scanner;

public class Eje14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el tamaño del arreglo (N)
        System.out.print("Ingrese el número de elementos (N): ");
        int n = scanner.nextInt();
        
        // Crear el arreglo A
        int[] A = new int[n];
        
        // Llenar el arreglo A con los valores ingresados
        System.out.println("\nIngrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + (i + 1) + "]: ");
            A[i] = scanner.nextInt();
        }
        
        // Crear el arreglo B con las diferencias sucesivas
        int[] B = new int[n - 1]; // Tamaño de B es N-1
        for (int i = 0; i < n - 1; i++) {
            B[i] = A[i] - A[i + 1]; // Diferencia entre elementos sucesivos
        }
        
        // Mostrar el arreglo B
        System.out.println("\nArreglo resultante B (diferencias sucesivas):");
        for (int num : B) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
}