package Ejercicios;

public class Ejer19 {
    public static void main(String[] args) {
        // Definir dimensiones de la matriz (n filas, m columnas)
        int n = 5; // Ejemplo: 4 filas
        int m = 5; // Ejemplo: 5 columnas
        
        // Crear matriz de n x m inicializada con ceros
        int[][] matriz = new int[n][m];
        
        // Llenar la diagonal principal con unos
        for (int i = 0; i < Math.min(n, m); i++) {
            matriz[i][i] = 1;
        }
        
        // Imprimir la matriz
        System.out.println("Matriz con diagonal principal en unos:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
