package Ejercicio;

import java.util.Scanner;

public class Eje6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el número de viviendas (N)
        System.out.print("Ingrese el número de viviendas (N): ");
        int n = scanner.nextInt();
        
        // Crear arreglos para alquileres, porcentajes y ganancias
        double[] alquileres = new double[n];
        double[] porcentajes = new double[n];
        double[] ganancias = new double[n];
        
        // Llenar el arreglo de alquileres
        System.out.println("\nIngrese los alquileres de las " + n + " viviendas:");
        for (int i = 0; i < n; i++) {
            System.out.print("Alquiler de la vivienda " + (i + 1) + ": ");
            alquileres[i] = scanner.nextDouble();
        }
        
        // Llenar el arreglo de porcentajes de ganancia
        System.out.println("\nIngrese los porcentajes de ganancia de las " + n + " viviendas (%):");
        for (int i = 0; i < n; i++) {
            System.out.print("Porcentaje de la vivienda " + (i + 1) + ": ");
            porcentajes[i] = scanner.nextDouble();
        }
        
        // Calcular las ganancias (alquiler * porcentaje / 100)
        for (int i = 0; i < n; i++) {
            ganancias[i] = alquileres[i] * (porcentajes[i] / 100);
        }
        
        // Mostrar el arreglo de ganancias
        System.out.println("\nGanancias por vivienda:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Vivienda %d: %.2f\n", (i + 1), ganancias[i]);
        }
        
        scanner.close();
    }
}