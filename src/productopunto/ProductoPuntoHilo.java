package productopunto;

public class ProductoPuntoHilo extends Thread {
    private int id;
    private int N;
    private int[] vector;
    private int[][] matriz;
    private int[] resultado;

    public ProductoPuntoHilo(int id, int N, int[] vector, int[][] matriz, int[] resultado) {
        this.id = id;
        this.N = N;
        this.vector = vector;
        this.matriz = matriz;
        this.resultado = resultado;
    }

    
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += vector[i] * matriz[i][id];
        }
        resultado[id] = sum;
    }
}