package Ejercicios;

import java.util.Scanner;

public class Eje1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        //Solicitar el valor N
        System.out.println("Ingrese el numero de elementos (N): ");
        int n = entrada.nextInt();
        
        //Crear el arreglo de tamaño N
        int[] arreglo = new int[n];
        
        
        //Leer los N numeros y guardarlos en el arreglo
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el numero " + (i + 1) + ": ");
            arreglo [i] = entrada.nextInt();
        }
        
        //Calcular la suma
        int suma = 0;
        for (int numero : arreglo) {
            suma += numero;
        }
        
        //Mostrar el resultado 
        System.out.println("La suma de los " + n + " numeros es " + suma);
        
        entrada.close();
        
    }
}