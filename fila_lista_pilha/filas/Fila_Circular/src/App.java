public class App {
    public class FilaCircular {
        private int[] fila;
        private int front;
        private int rear;
        private int capacidade;
        
        public FilaCircular(int capacidade) {
            this.capacidade = capacidade;
            fila = new int[capacidade];
            front = rear = -1;
        }

        // Verifica se a fila está cheia
        public boolean cheia() {
            return (rear + 1) % capacidade == front;
        }

        // Verifica se a fila está vazia
        public boolean vazia() {
            return front == -1;
        }

        // Adiciona um elemento à fila
        public void enqueue(int valor) {
            if (cheia()) {
                System.out.println("Fila cheia!");
                return;
            }
            if (vazia()) {
                front = 0;
            }
            rear = (rear + 1) % capacidade;
            fila[rear] = valor;
            System.out.println("Elemento " + valor + " adicionado.");
        }

        // Remove um elemento da fila
        public void dequeue() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return;
            }
            int valorRemovido = fila[front];
            if (front == rear) {
                front = rear = -1; // Fila ficou vazia
            } else {
                front = (front + 1) % capacidade;
            }
            System.out.println("Elemento " + valorRemovido + " removido.");
        }

        // Exibe os elementos da fila
        public void exibirFila() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return;
            }
            int i = front;
            while (i != rear) {
                System.out.print(fila[i] + " ");
                i = (i + 1) % capacidade;
            }
            System.out.println(fila[rear]); // último elemento
        }
    }
    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular(5);

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        fila.enqueue(40);
        fila.enqueue(50);

        fila.exibirFila();

        fila.dequeue();
        fila.dequeue();

        fila.exibirFila();

        fila.enqueue(60);
        fila.enqueue(70);

        fila.exibirFila();
    }
}
