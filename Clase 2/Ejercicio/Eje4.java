package Ejercicio;

import java.util.Scanner;

public class Eje4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Primer grupo de edades
        System.out.print("Ingrese el numero de personas del primer grupo: ");
        int tamañoGrupo1 = entrada.nextInt();
        int[] grupo1 = new int[tamañoGrupo1];

        System.out.println("Ingrese las edades del primer grupo:");
        for (int i = 0; i < tamañoGrupo1; i++) {
            System.out.print("Edad de la persona " + (i + 1) + ": ");
            grupo1[i] = entrada.nextInt();
        }

        //Segundo grupo de edades
        System.out.print("\nIngrese el numero de personas del segundo grupo: ");
        int tamañoGrupo2 = entrada.nextInt();
        int[] grupo2 = new int[tamañoGrupo2];

        System.out.println("Ingrese las edades del segundo grupo:");
        for (int i = 0; i < tamañoGrupo2; i++) {
            System.out.print("Edad de la persona " + (i + 1) + ": ");
            grupo2[i] = entrada.nextInt();
        }

        //Encontara la edad maxima
        int edadMax = Integer.MIN_VALUE;

        for (int edad : grupo1) {
            if (edad > edadMax) {
                edadMax = edad;
            }
        }

        for (int edad : grupo2) {
            if (edad > edadMax) {
                edadMax = edad;
            }
        }

        //Mostrara resultados   
        System.out.println("\nLa mayor edad entre los dos grupos es: " + edadMax);

        entrada.close();
    }


}
