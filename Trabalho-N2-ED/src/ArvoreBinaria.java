

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
        imprimirInOrdem(raiz);
        System.out.println();
    }

    private void imprimirInOrdem(NoArvore<T> atual) {
        if (atual != null) {
            imprimirInOrdem(atual.esquerda);
            System.out.print(atual.dado + " ");
            imprimirInOrdem(atual.direita);
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
}