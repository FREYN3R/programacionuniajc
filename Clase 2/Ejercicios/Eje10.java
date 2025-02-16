package Ejercicios;

import java.util.Scanner;

public class Eje10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el tamaño del arreglo (N)
        System.out.print("Ingrese el número de elementos (N): ");
        int n = scanner.nextInt();
        
        // Crear el arreglo A
        int[] A = new int[n];
        
        // Llenar el arreglo A
        System.out.println("\nIngrese los elementos del arreglo A:");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]: ");
            A[i] = scanner.nextInt();
        }
        
        // Calcular el tamaño del arreglo resultante B
        int tamanoB = (n % 2 == 0) ? n / 2 : (n / 2) + 1;
        int[] B = new int[tamanoB];
        
        // Llenar el arreglo B con las sumas de opuestos
        for (int i = 0; i < tamanoB; i++) {
            int opuesto = n - 1 - i;
            if (i == opuesto) { // Elemento central (si N es impar)
                B[i] = A[i];
            } else {
                B[i] = A[i] + A[opuesto];
            }
        }
        
        // Mostrar el arreglo B
        System.out.println("\nArreglo resultante B:");
        for (int num : B) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
}