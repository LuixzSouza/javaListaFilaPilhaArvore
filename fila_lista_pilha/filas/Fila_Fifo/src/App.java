public class App {
    // Classe que representa a fila
    static class Fila {
        int[] fila;  // Array para armazenar os elementos da fila
        int inicio;  // Ponteiro para o início da fila (elemento a ser removido)
        int fim;     // Ponteiro para o fim da fila (último elemento inserido)
        int tamanho; // Número de elementos na fila
        int capacidadeMaxima; // Capacidade máxima da fila

        // Construtor da fila que define o tamanho máximo da fila
        Fila(int capacidadeMaxima) {
            this.capacidadeMaxima = capacidadeMaxima;
            this.fila = new int[capacidadeMaxima];  // Aloca o array da fila
            this.inicio = 0;  // Inicializa o ponteiro de início
            this.fim = 0;     // Inicializa o ponteiro de fim
            this.tamanho = 0; // Inicializa o tamanho da fila
        }

        // Função para inserir um elemento na fila
        void inserir(int valor) {
            // Verifica se a fila está cheia
            if (tamanho == capacidadeMaxima) {
                System.out.println("Fila cheia! Não é possível inserir.");
                return;
            }

            // Insere o valor no fim da fila
            fila[fim] = valor;

            // Atualiza o ponteiro de fim da fila
            fim++;

            // Atualiza o tamanho da fila
            tamanho++;

            System.out.println("Elemento " + valor + " inserido na fila.");
        }

        // Função para remover um elemento da fila
        void remover() {
            // Verifica se a fila está vazia
            if (tamanho == 0) {
                System.out.println("Fila vazia! Não é possível remover.");
                return;
            }

            // Remove o elemento do início da fila
            System.out.println("Elemento " + fila[inicio] + " removido da fila.");

            // Atualiza o ponteiro de início da fila
            inicio++;

            // Atualiza o tamanho da fila
            tamanho--;
        }

        // Função para imprimir os elementos da fila
        void imprimir() {
            // Verifica se a fila está vazia
            if (tamanho == 0) {
                System.out.println("Fila vazia!");
                return;
            }

            // Imprime os elementos da fila
            System.out.print("Elementos da fila: ");
            for (int i = inicio; i < fim; i++) {
                System.out.print(fila[i] + " ");
            }
            System.out.println();
        }

        // Função para verificar se a fila está vazia
        boolean estaVazia() {
            return tamanho == 0;
        }

        // Função para verificar se a fila está cheia
        boolean estaCheia() {
            return tamanho == capacidadeMaxima;
        }
    }

    public static void main(String[] args) {
        // Criando uma fila com capacidade máxima de 5 elementos
        Fila fila = new Fila(5);

        // Testando inserções na fila
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
        fila.inserir(50);

        // Tentando inserir um elemento em uma fila cheia
        fila.inserir(60); // A fila já está cheia, não deve inserir

        // Imprimindo os elementos da fila
        fila.imprimir();

        // Removendo elementos da fila
        fila.remover();
        fila.remover();

        // Imprimindo os elementos da fila após remoções
        fila.imprimir();

    }
}
