package Ejercicios;

import java.util.Scanner;

public class Eje7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Arreglo A de 10 elementos
        int[] A = new int[10];
        
        // Solicitar los 10 números para el arreglo A
        System.out.println("Ingrese 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            A[i] = scanner.nextInt();
        }
        
        // Contar pares e impares
        int contadorPares = 0;
        int contadorImpares = 0;
        
        for (int num : A) {
            if (num % 2 == 0) {
                contadorPares++;
            } else {
                contadorImpares++;
            }
        }
        
        // Crear arreglos para pares e impares
        int[] pares = new int[contadorPares];
        int[] impares = new int[contadorImpares];
        
        // Llenar los arreglos pares e impares
        int indicePares = 0;
        int indiceImpares = 0;
        
        for (int num : A) {
            if (num % 2 == 0) {
                pares[indicePares] = num;
                indicePares++;
            } else {
                impares[indiceImpares] = num;
                indiceImpares++;
            }
        }
        
        // Mostrar resultados
        System.out.println("\nNúmeros pares:");
        for (int par : pares) {
            System.out.print(par + " ");
        }
        
        System.out.println("\n\nNúmeros impares:");
        for (int impar : impares) {
            System.out.print(impar + " ");
        }
        
        scanner.close();
    }
}