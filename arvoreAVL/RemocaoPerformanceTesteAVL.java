package arvoreAVL;

import java.util.Random;

public class RemocaoPerformanceTesteAVL {
    public static void testeDesempenho(){ 
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        Random random = new Random();
        int[] tamanhos = {100, 500, 1000, 10000, 20000};

        for (int tamanho : tamanhos) {
            for (int i = 0; i < tamanho; i++) {
                int valorAleatorio = random.nextInt();
                arvoreAVL.inserir(valorAleatorio);
            }

            long inicio = System.currentTimeMillis();

            for (int i = 0; i < tamanho; i++){
                arvoreAVL.remover(random.nextInt());
            }

            long fim = System.currentTimeMillis();
            System.out.println("Tempo de busca para " + tamanho + " elementos: " + (fim - inicio) + " ms");
        }
    }
}
