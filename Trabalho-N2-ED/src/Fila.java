public class Fila<T> implements EstruturaLinear<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void adicionar(T elemento) {
        enqueue(elemento);
    }

    @Override
    public T remover() {
        return dequeue();
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

    public void enqueue(T elemento) {
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
        System.out.print("SAIDA <-- [ ");
        while (atual != null) {
            System.out.print(atual.getDado());
            if (atual.getProximo() != null) {
                System.out.print(" , ");
            }
            atual = atual.getProximo();
        }
        System.out.println(" ] <-- ENTRADA");
    }

    public T dequeue() {
        if (inicio == null) {
            throw new IllegalStateException();
        }
        T dado = inicio.getDado();
        inicio = inicio.getProximo();
        if (inicio != null) {
            inicio.setAnterior(null);
        } else {
            fim = null;
        }
        tamanho--;
        return dado;
    }
}