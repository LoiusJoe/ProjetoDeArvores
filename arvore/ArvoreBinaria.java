package arvore;

public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private Node inserir(Node node, int valor) {
        if (node == null) {
            node = new Node(valor);
            return node;
        }

        if (valor < node.valor)
            node.esquerda = inserir(node.esquerda, valor);
        else if (valor > node.valor)
            node.direita = inserir(node.direita, valor);

        return node;
    }

    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    private Node remover(Node node, int valor) {
        if (node == null) return node;

        if (valor < node.valor)
            node.esquerda = remover(node.esquerda, valor);
        else if (valor > node.valor)
            node.direita = remover(node.direita, valor);
        else {
            if (node.esquerda == null)
                return node.direita;
            else if (node.direita == null)
                return node.esquerda;

            node.valor = valorMinimo(node.direita);
            node.direita = remover(node.direita, node.valor);
        }

        return node;
    }

    private int valorMinimo(Node node) {
        int valorMinimo = node.valor;
        while (node.esquerda != null) {
            valorMinimo = node.esquerda.valor;
            node = node.esquerda;
        }
        return valorMinimo;
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(Node node, int valor) {
        if (node == null) return false;

        if (valor == node.valor) return true;

        if (valor < node.valor)
            return buscar(node.esquerda, valor);
        else
            return buscar(node.direita, valor);
    }
    
}