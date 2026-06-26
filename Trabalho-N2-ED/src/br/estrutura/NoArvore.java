package br.estrutura;

public class NoArvore<T extends Comparable<T>> {
    public T dado;
    public NoArvore<T> esquerda;
    public NoArvore<T> direita;

    public NoArvore(T dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }
}