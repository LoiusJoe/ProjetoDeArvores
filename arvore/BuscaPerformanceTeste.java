package arvore;

import java.util.Random;

public class BuscaPerformanceTeste {
    public static void testeDesempenho() {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        Random random = new Random();
        int[] tamanhos = {100, 500, 1000, 10000, 20000};

        for (int tamanho : tamanhos) {
            for (int i = 0; i < tamanho; i++) {
                int valorAleatorio = random.nextInt();
                arvoreBinaria.inserir(valorAleatorio);
            }        
            
            long inicio = System.currentTimeMillis();

            
            for (int i = 0; i < tamanho; i++){
                arvoreBinaria.buscar(random.nextInt());
            }
            long fim = System.currentTimeMillis();
            System.out.println("Tempo de busca para " + tamanho + " elementos: " + (fim - inicio) + " ms");
        }       
    }
}
