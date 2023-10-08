package arvoreAVL;

public class Node {
    int dado;
    int altura;
    Node esquerda, direita;

    Node(int valor) {
        dado = valor;
        altura = 1;
    }
}
