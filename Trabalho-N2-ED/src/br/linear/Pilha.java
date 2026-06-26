package br.linear;

import br.estrutura.EstruturaLinear;
import br.estrutura.No;

public class Pilha<T> implements EstruturaLinear<T> {
    private No<T> topo;
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public void adicionar(T elemento) {
        push(elemento);
    }
    public void imprimir() {
        No<T> atual = topo;
        System.out.println("=== TOPO ===");
        while (atual != null) {
            System.out.println("| " + atual.getDado() + " |");
            atual = atual.getProximo();
        }
        System.out.println("============");
    }

    @Override
    public T remover() {
        return pop();
    }

    @Override
    public boolean busca(T elemento) {
        No<T> atual = topo;
        while (atual != null) {
            if (atual.getDado().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    public void push(T elemento) {
        No<T> novo = new No<>(elemento);
        if (topo != null) {
            novo.setProximo(topo);
            topo.setAnterior(novo);
        }
        topo = novo;
        tamanho++;
    }

    public T pop() {
        if (topo == null) {
            throw new IllegalStateException();
        }
        T dado = topo.getDado();
        topo = topo.getProximo();
        if (topo != null) {
            topo.setAnterior(null);
        }
        tamanho--;
        return dado;
    }
}