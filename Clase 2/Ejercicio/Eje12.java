package Ejercicio;

import java.util.Scanner;

public class Eje12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el tamaño del arreglo (N)
        System.out.print("Ingrese el número de elementos (N): ");
        int n = scanner.nextInt();
        
        // Crear y llenar el arreglo A
        int[] A = new int[n];
        System.out.println("\nIngrese los elementos del arreglo A:");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + (i + 1) + "]: ");
            A[i] = scanner.nextInt();
        }
        
        // Solicitar el valor X a buscar
        System.out.print("\nIngrese el valor X a buscar: ");
        int X = scanner.nextInt();
        
        // Contar las ocurrencias de X en A
        int contador = 0;
        for (int num : A) {
            if (num == X) {
                contador++;
            }
        }
        
        // Crear el arreglo B con las posiciones (basadas en 1)
        int[] B = new int[contador];
        int indiceB = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == X) {
                B[indiceB] = i + 1; // Posición basada en 1
                indiceB++;
            }
        }
        
        // Mostrar resultados
        if (contador == 0) {
            System.out.println("\nEl valor " + X + " no está en el arreglo.");
        } else {
            System.out.print("\nPosiciones de " + X + " en A: ");
            for (int pos : B) {
                System.out.print(pos + " ");
            }
        }
        
        scanner.close();
    }
}