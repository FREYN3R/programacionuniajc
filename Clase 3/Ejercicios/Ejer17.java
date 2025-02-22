package Ejercicios;

public class Ejer17 {
    public static void main(String[] args) {
        // Definir una matriz de ejemplo (3x3)
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Arreglo para almacenar la suma de cada fila
        int[] sumaFilas = new int[filas];
        // Arreglo para almacenar la suma de cada columna
        int[] sumaColumnas = new int[columnas];

        // Calcular suma de cada fila
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sumaFilas[i] += matriz[i][j];
            }
        }

        // Calcular suma de cada columna
        for (int j = 0; j < columnas; j++) {
            for (int i = 0; i < filas; i++) {
                sumaColumnas[j] += matriz[i][j];
            }
        }

        // Mostrar resultados
        System.out.println("Suma de cada fila:");
        for (int suma : sumaFilas) {
            System.out.print(suma + " ");
        }

        System.out.println("\nSuma de cada columna:");
        for (int suma : sumaColumnas) {
            System.out.print(suma + " ");
        }
    }
}