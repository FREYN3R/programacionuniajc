import java.util.*;

public class MensajeriaDijkstra {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Nombres de los puntos de entrega
        String[] puntos = {"Bodega", "Zona A", "Zona B", "Zona C", "Zona D", "Zona E"};

        // Matriz que representa la distancias entre puntos
        int[][] grafo = {
            { 0, 2, 6, 0, 0, 0 },  // Bodega
            { 2, 0, 0, 5, 0, 0 },  // Zona A
            { 6, 0, 0, 8, 0, 0 },  // Zona B
            { 0, 5, 8, 0,15,10 },  // Zona C
            { 0, 0, 0,15, 0, 6 },  // Zona D
            { 0, 0, 0,10, 6, 0 }   // Zona E
        };

        int origen = 0; // Bodega
        int destino = 5; // Zona a la que se quiere llegar
        dijkstra(grafo, origen, destino, puntos);
    }

    public static void dijkstra(int[][] grafo, int origen, int destino, String[] puntos) {
        int n = grafo.length;
        int[] dist = new int[n];
        boolean[] visitado = new boolean[n];
        int[] anterior = new int[n];

        Arrays.fill(dist, INF);
        Arrays.fill(anterior, -1);
        dist[origen] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = nodoMinimo(dist, visitado);
            if (u == -1) break;
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != 0 && dist[u] != INF &&
                    dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                    anterior[v] = u;
                }
            }
        }

        // Mostrar solo la ruta desde Bodega hasta Zona E
        System.out.print("Ruta más corta de " + puntos[origen] + " a " + puntos[destino] + ": ");
        if (dist[destino] == INF) {
            System.out.println("No hay ruta");
        } else {
            System.out.print("Distancia = " + dist[destino] + " | Ruta: ");
            imprimirRuta(destino, anterior, puntos);
            System.out.println();
        }
    }

    public static int nodoMinimo(int[] dist, boolean[] visitado) {
        int min = INF, minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visitado[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void imprimirRuta(int actual, int[] anterior, String[] puntos) {
        if (actual == -1) return;
        imprimirRuta(anterior[actual], anterior, puntos);
        System.out.print(puntos[actual] + " ");
    }
}
