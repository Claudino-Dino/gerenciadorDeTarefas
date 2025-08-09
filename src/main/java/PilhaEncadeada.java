public class PilhaEncadeada<T> {
    No<T> top;

    public void push(T valor) {
        No<T> noAdicionar = new No<>(valor);

        noAdicionar.proximo = top;
        top = noAdicionar;
    }

    public T peek(int indice) {
        if (top == null) {
            throw new RuntimeException("Pilha vazia!");
        }

        if (indice >= tamanhoPilha()) {
            System.out.println("Valor maior que tamanho da pilha!");
            return null;
        }

        No<T> noAtual = top;

        for (int i = 0; i < indice; i++) {
            noAtual = noAtual.proximo;
        }

        return noAtual.valor;
    }

    public T remove(int indice) {
        if (top == null) {
            throw new RuntimeException("Pilha vazia.");
        }

        if (indice < 0 || indice > tamanhoPilha() - 1) {
            throw new RuntimeException("Índice inexistente na pilha.");
        }


        if (indice == 0) {
            No<T> noAtual = top;
            top = noAtual.proximo;
            noAtual.proximo = null;
            return noAtual.valor;
        }

        No<T> noAnterior = top;
        for (int i = 0; i < indice - 1; i++) {
            noAnterior = noAnterior.proximo;
        }

        No<T> noRemover = noAnterior.proximo;
        noAnterior.proximo = noRemover.proximo;
        noRemover.proximo = null;

        return noRemover.valor;
    }

    public int tamanhoPilha() {

        int i = 0;
        No<T> noAtual = top;
        while (noAtual != null) {
            noAtual = noAtual.proximo;
            i++;
        }

        return i;
    }

}