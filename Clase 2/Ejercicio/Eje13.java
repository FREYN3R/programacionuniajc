package Ejercicio;

import java.util.Scanner;

public class Eje13 {
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
        
        // Calcular la media
        double suma = 0;
        for (int num : A) {
            suma += num;
        }
        double media = suma / n;
        System.out.printf("\nLa media del arreglo es: %.2f\n", media);
        
        // Contar elementos mayores y menores que la media
        int contMayores = 0, contMenores = 0;
        for (int num : A) {
            if (num > media) {
                contMayores++;
            } else if (num < media) {
                contMenores++;
            }
        }
        
        // Crear arreglos para mayores y menores que la media
        int[] mayores = new int[contMayores];
        int[] menores = new int[contMenores];
        
        // Llenar los arreglos
        int idxMay = 0, idxMen = 0;
        for (int num : A) {
            if (num > media) {
                mayores[idxMay] = num;
                idxMay++;
            } else if (num < media) {
                menores[idxMen] = num;
                idxMen++;
            }
        }
        
        // Mostrar resultados
        System.out.println("\nElementos mayores que la media:");
        if (contMayores == 0) {
            System.out.println("No hay elementos mayores que la media.");
        } else {
            for (int num : mayores) {
                System.out.print(num + " ");
            }
        }
        
        System.out.println("\n\nElementos menores que la media:");
        if (contMenores == 0) {
            System.out.println("No hay elementos menores que la media.");
        } else {
            for (int num : menores) {
                System.out.print(num + " ");
            }
        }
        
        scanner.close();
    }
}
