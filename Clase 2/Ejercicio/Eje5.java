package Ejercicio;

import java.util.Scanner;

public class Eje5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        // Solicitamos el número de productos (N)
        System.out.print("Ingrese el número de productos (N): ");
        int n = entrada.nextInt();
        entrada.nextLine(); // Limpiar el buffer
        
        // Creamos arreglos para PU, CC, Descripción y TG
        double[] PU = new double[n];
        int[] CC = new int[n];
        String[] descripciones = new String[n];
        double[] TG = new double[n];
        
        // Llenamos los arreglos con datos del usuario
        for (int i = 0; i < n; i++) {
            System.out.println("\nProducto " + (i + 1) + ":");
            System.out.print("Descripción: ");
            descripciones[i] = entrada.nextLine();
            
            System.out.print("Precio Unitario (PU): ");
            PU[i] = entrada.nextDouble();
            
            System.out.print("Cantidad Comprada (CC): ");
            CC[i] = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer
            
            // Calcular TG[i] = PU[i] * CC[i]
            TG[i] = PU[i] * CC[i];
        }
        
        // a. Mostramos el arreglo TG
        System.out.println("\nTotal gastado por producto:");
        for (int i = 0; i < n; i++) {
            System.out.println(descripciones[i] + ": " + TG[i]);
        }
        
        // b. Calculamos el total general
        double totalGeneral = 0;
        for (double total : TG) {
            totalGeneral += total;
        }
        System.out.println("\nTotal general de todas las compras: " + totalGeneral);
        
        // c. Encontrar el producto con mayor gasto
        int indiceMax = 0;
        for (int i = 1; i < n; i++) {
            if (TG[i] > TG[indiceMax]) {
                indiceMax = i;
            }
        }
        System.out.println("\nProducto con mayor gasto:");
        System.out.println("Descripción: " + descripciones[indiceMax]);
        System.out.println("Total gastado: " + TG[indiceMax]);
        
        entrada.close();
    }
}