package productopunto;

import java.util.Random;
import java.util.Scanner;

public class ProductoPunto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el tamaño N de la matriz cuadrada: ");
        int N = sc.nextInt();

        int[] vector = new int[N];
        int[][] matriz = new int[N][N];
        int[] resultado = new int[N];

        // Llena el vector con números aleatorios entre 1 y 9
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            vector[i] = rand.nextInt(9) + 1;
        }

        // Llena la matriz con números aleatorios entre 1 y 9
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = rand.nextInt(9) + 1;
            }
        }

        // Crea y ejecuta los hilos
        ProductoPuntoHilo[] hilos = new ProductoPuntoHilo[N];
        for (int i = 0; i < N; i++) {
            hilos[i] = new ProductoPuntoHilo(i, N, vector, matriz, resultado);
            hilos[i].start();
        }

        // Espera a que todos los hilos terminen
        for (int i = 0; i < N; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
        System.out.println("El vector generado es: ");
        for (int i = 0; i < N; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
        
        
        System.out.println("La matriz generada es: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        
        
        System.out.println("El resultado del producto punto es: ");
        for (int i = 0; i < N; i++) {
            System.out.print(resultado[i] + " ");
        }
    }
}
