public interface EstruturaLinear<T> {
    void adicionar(T elemento);
    T remover();
    boolean busca(T elemento);
    int tamanho();
}