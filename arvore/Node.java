package arvore;

class Node {
    int valor;
    Node esquerda;
    Node direita;

    Node(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}