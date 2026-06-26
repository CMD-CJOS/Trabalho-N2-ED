

public class ArvoreBinaria<T extends Comparable<T>> {
    private NoArvore<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T dado) {
        raiz = inserirRecursivo(raiz, dado);
    }

    private NoArvore<T> inserirRecursivo(NoArvore<T> atual, T dado) {
        if (atual == null) {
            return new NoArvore<>(dado);
        }
        if (dado.compareTo(atual.dado) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, dado);
        } else if (dado.compareTo(atual.dado) > 0) {
            atual.direita = inserirRecursivo(atual.direita, dado);
        }
        return atual;
    }

    public void imprimir() {
        if (raiz == null) {
            System.out.println("Arvore Vazia");
            return;
        }
        imprimirRecursivo(raiz, "", true);
        System.out.println();
    }

    private void imprimirRecursivo(NoArvore<T> atual, String prefixo, boolean isCauda) {
        if (atual.direita != null) {
            imprimirRecursivo(atual.direita, prefixo + (isCauda ? "│   " : "    "), false);
        }
        System.out.println(prefixo + (isCauda ? "└── " : "┌── ") + atual.dado);
        if (atual.esquerda != null) {
            imprimirRecursivo(atual.esquerda, prefixo + (isCauda ? "    " : "│   "), true);
        }
    }

    public boolean busca(T dado) {
        return buscaRecursiva(raiz, dado);
    }

    private boolean buscaRecursiva(NoArvore<T> atual, T dado) {
        if (atual == null) {
            return false;
        }
        if (dado.equals(atual.dado)) {
            return true;
        }
        return dado.compareTo(atual.dado) < 0
                ? buscaRecursiva(atual.esquerda, dado)
                : buscaRecursiva(atual.direita, dado);
    }

    public void imprimirCaminho(T dado) {
        System.out.print("Caminho para " + dado + ": ");
        if (!buscaCaminho(raiz, dado)) {
            System.out.println("Não encontrado.");
        } else {
            System.out.println("Fim.");
        }
    }

    private boolean buscaCaminho(NoArvore<T> atual, T dado) {
        if (atual == null) return false;

        System.out.print(atual.dado + " -> "); // Exibe o nó por onde está passando

        if (dado.equals(atual.dado)) return true;

        return dado.compareTo(atual.dado) < 0
                ? buscaCaminho(atual.esquerda, dado)
                : buscaCaminho(atual.direita, dado);
    }
}