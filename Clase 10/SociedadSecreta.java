import java.util.Arrays;

public class SociedadSecreta {

    public static String sociedadNom(String[] nombres) {

        char[] iniciales = new char[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            iniciales[i] = nombres[i].charAt(0);
        }

        Arrays.sort(nombres);

        return new String(iniciales);
    }

    public static void main(String[] args) {
        System.out.println(sociedadNom(new String[]{"Juan", "Pedro", "Maria", "Ana"}));
        System.out.println(sociedadNom(new String[]{"Julian", "Mar", "Pablo", "Sofia"}));
    }
}

    
