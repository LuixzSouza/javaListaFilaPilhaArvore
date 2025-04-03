package ScriptAulas;

public class Runner {
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
