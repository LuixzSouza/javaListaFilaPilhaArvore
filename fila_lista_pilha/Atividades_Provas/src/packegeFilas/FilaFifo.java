package packegeFilas;

import java.util.LinkedList;
import java.util.Queue;

public class FilaFifo {

    // Criando a fila usando LinkedList
    private Queue<String> fila;

    public FilaFifo() {
        fila = new LinkedList<>();
    }

    // Método para inserir um elemento (enqueue)
    public void inserir(String elemento) {
        fila.add(elemento); // Adiciona no final da fila
        System.out.println("Inserido: " + elemento);
    }

    // Método para remover um elemento (dequeue)
    public String remover() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia!");
            return null;
        }
        String removido = fila.poll(); // Remove o primeiro elemento
        System.out.println("Removido: " + removido);
        return removido;
    }

    // Método para exibir a fila
    public void exibirFila() {
        System.out.println("Conteúdo da fila: " + fila);
    }

    // Método principal para teste
    public static void main(String[] args) {
        FilaFifo minhaFila = new FilaFifo();

        minhaFila.inserir("Pessoa 1");
        minhaFila.inserir("Pessoa 2");
        minhaFila.inserir("Pessoa 3");

        minhaFila.exibirFila();
        minhaFila.remover();
        minhaFila.exibirFila();
    }
}

/*
 * FILAS X PILHA 
 * 
 * Entrada        [] [] [] [X] Saida
 * ->                          ->
 * 
 * FIFO (First in, First Out) ;
 * P.E.P.S (Primeiro a Entrar, Primeiro a Sair);
 */