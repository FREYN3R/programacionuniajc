package Ejercicio;

import java.util.Scanner;

public class Eje3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
    
        //Solicitamos el numero de elementos N
        System.out.println("Ingrese la cantidad de elementos (N): ");
        int n = entrada.nextInt();
    
        //Creamos arreglo de tamaño n
        int[] arreglo = new int[n];
    
        //Llenamos el arreglo con los numeros ingresados
        System.out.println("\nIngrese los numeros");
        for (int i = 0; i < n; i++) {
            System.out.println("Numero " + (i + 1) + ": ");
            arreglo[i] = entrada.nextInt();
        }
        
        //Calculamos suma de pares e impares
        int sumPares = 0;
        int sumImpares = 0;
        
        for (int numero : arreglo) {
            if (numero % 2==0){
                sumPares += numero;
            }else {
                sumImpares += numero;
            }
        }
        
        //Mostramos resultados
        System.out.println("\nSuma de numeros pares: " + sumPares);
        System.out.println("\nSuma de numeros impares: " + sumImpares);
        
        entrada.close();
            
        }
    }