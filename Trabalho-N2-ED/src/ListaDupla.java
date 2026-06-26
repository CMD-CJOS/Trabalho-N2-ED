public class ListaDupla<T extends Comparable<T>> implements EstruturaLinear<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void adicionar(T elemento) {
        No<T> novo = new No<>(elemento);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }
        tamanho++;
    }

    public void imprimir() {
        No<T> atual = inicio;
        System.out.print("[ ");
        while (atual != null) {
            System.out.print(atual.getDado());
            if (atual.getProximo() != null) {
                System.out.print(" <-> ");
            }
            atual = atual.getProximo();
        }
        System.out.println(" ]");
    }

    @Override
    public T remover() {
        if (inicio == null) {
            throw new IllegalStateException();
        }
        T dado = fim.getDado();
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.getAnterior();
            fim.setProximo(null);
        }
        tamanho--;
        return dado;
    }

    @Override
    public boolean busca(T elemento) {
        No<T> atual = inicio;
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

    public void inserirOrdenado(T elemento) {
        No<T> novo = new No<>(elemento);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else if (inicio.getDado().compareTo(elemento) >= 0) {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        } else {
            No<T> atual = inicio;
            while (atual.getProximo() != null && atual.getProximo().getDado().compareTo(elemento) < 0) {
                atual = atual.getProximo();
            }
            novo.setProximo(atual.getProximo());
            if (atual.getProximo() != null) {
                atual.getProximo().setAnterior(novo);
            } else {
                fim = novo;
            }
            novo.setAnterior(atual);
            atual.setProximo(novo);
        }
        tamanho++;
    }

    public void inverter() {
        No<T> atual = inicio;
        No<T> temp = null;
        while (atual != null) {
            temp = atual.getAnterior();
            atual.setAnterior(atual.getProximo());
            atual.setProximo(temp);
            atual = atual.getAnterior();
        }
        if (temp != null) {
            fim = inicio;
            inicio = temp.getAnterior();
        }
    }

    public void concatenar(ListaDupla<T> outraLista) {
        if (outraLista.inicio == null) return;
        if (this.inicio == null) {
            this.inicio = outraLista.inicio;
            this.fim = outraLista.fim;
        } else {
            this.fim.setProximo(outraLista.inicio);
            outraLista.inicio.setAnterior(this.fim);
            this.fim = outraLista.fim;
        }
        this.tamanho += outraLista.tamanho;
    }
}