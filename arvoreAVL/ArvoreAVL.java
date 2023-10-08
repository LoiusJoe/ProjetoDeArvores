package arvoreAVL;

public class ArvoreAVL {
    private Node raiz;

    private int altura(Node no) {
        if (no == null) return 0;
        return no.altura;
    }

    private int fatorDeBalanceamento(Node no) {
        if (no == null) return 0;
        return altura(no.esquerda) - altura(no.direita);
    }

    private Node rotacionarDireita(Node y) {
        Node x = y.esquerda;
        Node T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private Node rotacionarEsquerda(Node x) {
        Node y = x.direita;
        Node T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void inserir(int dado) {
        raiz = inserir(raiz, dado);
    }

    private Node inserir(Node node, int dado) {
        if (node == null) return new Node(dado);

        if (dado < node.dado)
            node.esquerda = inserir(node.esquerda, dado);
        else if (dado > node.dado)
            node.direita = inserir(node.direita, dado);
        else
            return node;

        node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita));

        int balanceamento = fatorDeBalanceamento(node);

        if (balanceamento > 1) {
            if (dado < node.esquerda.dado)
                return rotacionarDireita(node);
            else {
                node.esquerda = rotacionarEsquerda(node.esquerda);
                return rotacionarDireita(node);
            }
        }

        if (balanceamento < -1) {
            if (dado > node.direita.dado)
                return rotacionarEsquerda(node);
            else {
                node.direita = rotacionarDireita(node.direita);
                return rotacionarEsquerda(node);
            }
        }

        return node;
    }

    public void remover(int dado) {
        raiz = remover(raiz, dado);
    }

    private Node remover(Node node, int dado) {
        if (node == null) return node;

        if (dado < node.dado)
            node.esquerda = remover(node.esquerda, dado);
        else if (dado > node.dado)
            node.direita = remover(node.direita, dado);
        else {
            if (node.esquerda == null || node.direita == null) {
                Node temp = (node.esquerda != null) ? node.esquerda : node.direita;
                if (temp == null) {
                    temp = node;
                    node = null;
                } else
                    node = temp;
            } else {
                Node temp = encontrarNoComMenorValor(node.direita);
                node.dado = temp.dado;
                node.direita = remover(node.direita, temp.dado);
            }
        }

        if (node == null) return node;

        node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita));

        int balanceamento = fatorDeBalanceamento(node);

        if (balanceamento > 1) {
            if (fatorDeBalanceamento(node.esquerda) >= 0)
                return rotacionarDireita(node);
            else {
                node.esquerda = rotacionarEsquerda(node.esquerda);
                return rotacionarDireita(node);
            }
        }

        if (balanceamento < -1) {
            if (fatorDeBalanceamento(node.direita) <= 0)
                return rotacionarEsquerda(node);
            else {
                node.direita = rotacionarDireita(node.direita);
                return rotacionarEsquerda(node);
            }
        }

        return node;
    }

    private Node encontrarNoComMenorValor(Node node) {
        Node atual = node;
        while (atual.esquerda != null)
            atual = atual.esquerda;
        return atual;
    }

    public boolean buscar(int dado) {
        return buscar(raiz, dado);
    }

    private boolean buscar(Node node, int dado) {
        if (node == null) return false;

        if (dado == node.dado) return true;

        if (dado < node.dado)
            return buscar(node.esquerda, dado);
        else
            return buscar(node.direita, dado);
    }
    
}