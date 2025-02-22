public class EjemploMatrices {
    public static void main(String[] args) {
        
        //Declaracion de una matriz 3x3
        int[][] m = {{9, 3, 5},
                     {1, 4, 2},
                     {8, 7, 6}};

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print("m[" + i + "][" + j + "] = " + m[i][j] + " ");
            }
            
        }
    }
}
