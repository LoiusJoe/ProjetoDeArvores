package arvoreAVL;

public class ArvoreAVLMain {
    public static void main(String[] args) {
        System.out.println("\nTeste de inserção");
        InserirPerformanceTesteAVL.testeDesempenho();
        System.out.println("\nTeste de busca");
        BuscaPerformanceTesteAVL.testeDesempenho();
        System.out.println("\nTeste de remoção");
        RemocaoPerformanceTesteAVL.testeDesempenho();
    }
}

