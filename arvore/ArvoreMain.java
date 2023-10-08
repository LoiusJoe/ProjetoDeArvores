package arvore;

public class ArvoreMain {
    public static void main(String[] args) {
        System.out.println("\nTeste de inserção");
        InserirPerformanceTeste.testeDesempenho();
        System.out.println("\nTeste de busca");
        BuscaPerformanceTeste.testeDesempenho();
        System.out.println("\nTeste de remoção");
        RemocaoPerformanceTeste.testeDesempenho();
    }
}
