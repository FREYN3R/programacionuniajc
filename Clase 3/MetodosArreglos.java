public class MetodosArreglos {
    
    public String nombreSueldos (String[]n, int[]s) {
            
        int suma = 0;

        //Calcular la suma de los sueldos de los empleados
        for (int i = 0; i < s.length; i++) {
            suma += s[i];
        }

        //Calcular la promedio de los sueldos
        double promedio = suma / s.length;

        String cad = "";
        int cont = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] >= promedio) {
                cad += n[i] + "\n";
                cont++;
            }
        }

        cad += "Fueron " + cont + " Los empleados que tienen sueldo por encima del promedio: " +promedio;

        return cad; 
    }
}
