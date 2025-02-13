public class Ejercicio1 {
    public static void main(String[] args) {
        
        //Creación del objeto op de la clase OperacionesConArreglos
        OperacionesConArreglos op = new OperacionesConArreglos();
        
        // Crear un arreglo de enteros
        int[] a = {10, 20, 33, 24, 15, 26, 67, 28, 9, 10};

        // Mostrar los elementos del arreglo
        System.out.println(op.mostrarElementos(a));
        System.out.println("La suma de los elementos del arreglo es: " + op.sumarElementos(a));
        System.out.println("El promedio de los elementos del arreglo es: " + op.promedioElementos(a));
    }
}
