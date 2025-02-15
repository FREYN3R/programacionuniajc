package Ejercicios;

import java.util.Scanner;

public class Eje2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        //Solicitamos el numero de empleados N
        System.out.println("Ingrese el numero de empleados (N): ");
        int n = entrada.nextInt();
        
        //Crearmos los arreglos A (Sueldos), B (Asignaciones), C (Deducciones), y E (Neto)
        double[] A = new double[n];
        double[] B = new double[n];
        double[] C = new double[n];
        double[] E = new double[n];
        
        //Llenamos el arrglo A
        System.out.println("\nIngrese los sueldos de ls empleados: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Sueldos del empleado " + (i + 1) + ": ");
            A[i] = entrada.nextDouble();
        }
        
        //Llenamos el arreglo B
        System.out.println("Digite las asignaciones de los empleados: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Asignaciones del empleado " + (i + 1) + ": ");
            B[i] = entrada.nextDouble();
        }
        
        //Llenamos el arreglo C
        System.out.println("Digite las deducciones de los empleados: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Deduciones del empleado: " + (i + 1) + ": ");
            C[i] = entrada.nextDouble();
        }
        
        //Calculamos el arreglo E
        for (int i = 0; i < n; i++ ) {
        E[i] = A[i] + B[i] - C[i];
        }
        
        //Mostrar el resultado
        System.out.println("\nNeto a pagar por empleado: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Empleado " + (i + 1) + ": " + E[i]);
        }
        
        entrada.close();
        
    }
}