package Ejercicios;

import java.util.Scanner;

public class Eje16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el número de profesores (N)
        System.out.print("Ingrese el número de profesores (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Crear arreglos para nombres, edades y sexos
        String[] nombres = new String[n];
        int[] edades = new int[n];
        char[] sexos = new char[n];
        
        // Llenar los arreglos con datos del usuario
        System.out.println("\nIngrese la información de los profesores:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nProfesor " + (i + 1) + ":");
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();
            
            System.out.print("Edad: ");
            edades[i] = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            System.out.print("Sexo (M/F): ");
            sexos[i] = scanner.nextLine().charAt(0);
        }
        
        // a. Calcular la edad promedio
        int sumaEdades = 0;
        for (int edad : edades) {
            sumaEdades += edad;
        }
        double edadPromedio = (double) sumaEdades / n;
        System.out.printf("\nEdad promedio del grupo de profesores: %.2f\n", edadPromedio);
        
        // b. Nombre del profesor más joven
        int indiceMasJoven = 0;
        for (int i = 1; i < n; i++) {
            if (edades[i] < edades[indiceMasJoven]) {
                indiceMasJoven = i;
            }
        }
        System.out.println("Nombre del profesor más joven: " + nombres[indiceMasJoven]);
        
        // c. Nombre del profesor con mayor edad
        int indiceMayorEdad = 0;
        for (int i = 1; i < n; i++) {
            if (edades[i] > edades[indiceMayorEdad]) {
                indiceMayorEdad = i;
            }
        }
        System.out.println("Nombre del profesor con mayor edad: " + nombres[indiceMayorEdad]);
        
        // d. Número de profesoras con edad mayor al promedio
        int contProfesorasMayorPromedio = 0;
        for (int i = 0; i < n; i++) {
            if (sexos[i] == 'F' && edades[i] > edadPromedio) {
                contProfesorasMayorPromedio++;
            }
        }
        System.out.println("Número de profesoras con edad mayor al promedio: " + contProfesorasMayorPromedio);
        
        // e. Número de profesores con edad menor al promedio
        int contProfesoresMenorPromedio = 0;
        for (int i = 0; i < n; i++) {
            if (edades[i] < edadPromedio) {
                contProfesoresMenorPromedio++;
            }
        }
        System.out.println("Número de profesores con edad menor al promedio: " + contProfesoresMenorPromedio);
        
        scanner.close();
    }
}