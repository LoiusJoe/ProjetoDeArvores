package arvore;

import java.util.Random;

public class InserirPerformanceTeste {
    public static void testeDesempenho() {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        Random random = new Random();

        int[] tamanhos = {100, 500, 1000, 10000, 20000};

        for (int tamanho : tamanhos) {
            long inicio = System.currentTimeMillis();

            for (int i = 0; i < tamanho; i++) {
                int valorAleatorio = random.nextInt();
                arvoreBinaria.inserir(valorAleatorio);
            }

            long fim = System.currentTimeMillis();
            System.out.println("Tempo de inserção para " + tamanho + " elementos: " + (fim - inicio) + " ms");
        }
    }
}
