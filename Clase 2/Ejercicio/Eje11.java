package Ejercicio;

import java.util.Scanner;

public class Eje11 {
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
            System.out.print("A[" + i + "]: ");
            A[i] = scanner.nextInt();
        }
        
        // Contar elementos en cada categoría
        int contNegativos = 0, contCeros = 0, contPositivos = 0;
        
        for (int num : A) {
            if (num < 0) {
                contNegativos++;
            } else if (num == 0) {
                contCeros++;
            } else {
                contPositivos++;
            }
        }
        
        // Crear los arreglos para cada categoría
        int[] negativos = new int[contNegativos];
        int[] ceros = new int[contCeros];
        int[] positivos = new int[contPositivos];
        
        // Llenar los arreglos con los elementos correspondientes
        int idxNeg = 0, idxCer = 0, idxPos = 0;
        
        for (int num : A) {
            if (num < 0) {
                negativos[idxNeg] = num;
                idxNeg++;
            } else if (num == 0) {
                ceros[idxCer] = num;
                idxCer++;
            } else {
                positivos[idxPos] = num;
                idxPos++;
            }
        }
        
        // Mostrar los resultados
        System.out.println("\nElementos negativos:");
        if (contNegativos == 0) {
            System.out.println("No hay elementos negativos.");
        } else {
            for (int num : negativos) {
                System.out.print(num + " ");
            }
        }
        
        System.out.println("\n\nElementos iguales a cero:");
        if (contCeros == 0) {
            System.out.println("No hay ceros.");
        } else {
            for (int num : ceros) {
                System.out.print(num + " ");
            }
        }
        
        System.out.println("\n\nElementos positivos:");
        if (contPositivos == 0) {
            System.out.println("No hay elementos positivos.");
        } else {
            for (int num : positivos) {
                System.out.print(num + " ");
            }
        }
        
        scanner.close();
    }
}