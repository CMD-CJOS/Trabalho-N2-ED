import br.hierarquica.ArvoreBinaria;
import br.linear.Fila;
import br.linear.ListaDupla;
import br.linear.Pilha;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTE 1: LISTA DUPLAMENTE ENCADEADA ===");
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.adicionar(10);
        lista.adicionar(20);
        lista.imprimir();

        lista.inserirOrdenado(15);
        lista.inserirOrdenado(5);
        lista.imprimir();

        lista.inverter();
        lista.imprimir();

        lista.remover();
        lista.imprimir();

        System.out.println("\n=== TESTE 2: PILHA (LIFO) ===");
        Pilha<String> pilha = new Pilha<>();

        pilha.push("Alpha");
        pilha.push("Beta");
        pilha.push("Gama");
        pilha.imprimir();

        pilha.pop();
        pilha.imprimir();

        System.out.println("\n=== TESTE 3: FILA (FIFO) ===");
        Fila<Double> fila = new Fila<>();

        fila.enqueue(1.5);
        fila.enqueue(2.5);
        fila.imprimir();

        fila.dequeue();
        fila.imprimir();

        System.out.println("\n=== TESTE 4: ARVORE BINARIA DE BUSCA ===");
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(10);
        arvore.inserir(80);
        arvore.inserir(100);
        arvore.imprimir();
        arvore.imprimirCaminho(40);

        System.out.println("Busca pela chave 40: " + arvore.busca(40));
        System.out.println("Busca pela chave 99: " + arvore.busca(99));
    }
}