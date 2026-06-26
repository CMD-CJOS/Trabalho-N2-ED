class NoArvore<T extends Comparable<T>> {
    T dado;
    NoArvore<T> esquerda;
    NoArvore<T> direita;

    public NoArvore(T dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }
}