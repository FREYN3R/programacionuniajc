package Ejercicios;

public class Ejer20 {
    public static void main(String[] args) {
        int tamaño = 10;
        int[][] matriz = new int[tamaño][tamaño];
        
        // Llenar la matriz con unos
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = 1;
            }
        }
        
        // Colocar ceros en la diagonal secundaria (i + j = tamaño - 1)
        for (int i = 0; i < tamaño; i++) {
            int j = tamaño - 1 - i;
            matriz[i][j] = 0;
        }
        
        // Imprimir la matriz
        System.out.println("Matriz 10x10 con ceros en la diagonal secundaria:");
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
