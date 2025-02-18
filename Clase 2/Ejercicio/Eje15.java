package Ejercicio;

import java.util.Scanner;

public class Eje15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el número de trabajadores (N)
        System.out.print("Ingrese el número de trabajadores (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Crear arreglos para nombres y sueldos
        String[] nombres = new String[n];
        double[] sueldos = new double[n];
        
        // Llenar los arreglos con datos del usuario
        System.out.println("\nIngrese los nombres y sueldos de los trabajadores:");
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del trabajador " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
            
            System.out.print("Sueldo del trabajador " + (i + 1) + ": ");
            sueldos[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
        }
        
        // Calcular el sueldo promedio
        double sumaSueldos = 0;
        for (double sueldo : sueldos) {
            sumaSueldos += sueldo;
        }
        double sueldoPromedio = sumaSueldos / n;
        System.out.printf("\nEl sueldo promedio es: %.2f\n", sueldoPromedio);
        
        // Contar y mostrar trabajadores con sueldo promedio
        int contador = 0;
        System.out.println("\nTrabajadores con sueldo promedio:");
        for (int i = 0; i < n; i++) {
            if (sueldos[i] == sueldoPromedio) {
                System.out.println(nombres[i]);
                contador++;
            }
        }
        
        if (contador == 0) {
            System.out.println("Ningún trabajador tiene el sueldo promedio.");
        } else {
            System.out.println("Total de trabajadores con sueldo promedio: " + contador);
        }
        
        scanner.close();
    }
}