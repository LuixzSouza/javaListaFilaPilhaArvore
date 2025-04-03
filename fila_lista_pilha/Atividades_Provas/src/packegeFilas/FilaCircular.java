package packegeFilas;

public class FilaCircular {
    private int[] fila;
    private int ini;       // índice para remoção
    private int fim;       // índice para inserção
    private int capacidade;

    public FilaCircular(int capacidade) {
        // Adicionamos 1 à capacidade para diferenciar a condição de cheio
        this.capacidade = capacidade + 1;
        fila = new int[this.capacidade];
        ini = 0;
        fim = 0;
    }

    // Verifica se a fila está vazia
    public boolean isVazia() {
        return ini == fim;
    }

    // Verifica se a fila está cheia
    public boolean isCheia() {
        return (fim + 1) % capacidade == ini;
    }

    // Insere um elemento na fila
    public void inserir(int x) {
        if (isCheia()) {
            System.out.println("Fila cheia! Não é possível inserir " + x);
            return;
        }
        fila[fim] = x;
        fim = (fim + 1) % capacidade;
        System.out.println("Inserido: " + x);
    }

    // Remove um elemento da fila
    public int remover() {
        if (isVazia()) {
            System.out.println("Fila vazia! Não há elementos para remover.");
            return -1; // ou lançar uma exceção
        }
        int x = fila[ini];
        ini = (ini + 1) % capacidade;
        System.out.println("Removido: " + x);
        return x;
    }

    // Calcula o tamanho da fila
    public int tamanho() {
        if (fim >= ini) {
            return fim - ini;
        } else {
            return (capacidade - ini) + fim;
        }
    }

    // Método para exibir os elementos atuais da fila
    public void exibirFila() {
        System.out.print("Conteúdo da fila: ");
        int t = tamanho();
        for (int i = 0; i < t; i++) {
            System.out.print(fila[(ini + i) % capacidade] + " ");
        }
        System.out.println();
    }

    // Método principal para testar a fila circular
    public static void main(String[] args) {
        // Cria uma fila circular com capacidade para 5 elementos (5 + 1 na implementação)
        FilaCircular filaCircular = new FilaCircular(5);

        filaCircular.inserir(10);
        filaCircular.inserir(20);
        filaCircular.inserir(30);
        filaCircular.inserir(40);
        filaCircular.exibirFila();

        filaCircular.remover();
        filaCircular.remover();
        filaCircular.exibirFila();

        filaCircular.inserir(50);
        filaCircular.inserir(60);
        filaCircular.inserir(70);  // Este pode não ser inserido se a fila estiver cheia
        filaCircular.exibirFila();

        System.out.println("Tamanho atual da fila: " + filaCircular.tamanho());
    }
}


/*
 * Para Inserir
 * q[fim++] = x;
 * 
 * if (fim == n) fim = 0; ou -> fim = fim % n;
 * 
 * Para remover
 *  x = q[ini++];
 * 
 * if (ini == n) ini = 0; ou -> ini = ini % n;
 * 
 * Fila vazia: ini == fim;
 * 
 * Fila cheia:
 * fim + 1 == ini || (fim + 1 == n && ini == 0)
 * Ou
 * (fim + 1) % n == ini;
 * 
 * Tamanho
 * - if (fim >= ini) tam = fim = ini;
 * - if (fim < ini) tam = (n = ini) + (fim - 0);
 */
