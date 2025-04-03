package ScriptAulas;

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

package ScriptAulas;

import java.util.Random;

class Usuario {
    int id;
    String nome;
    int idade;
    String email;

    public Usuario(int id, String nome, int idade, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public boolean atendeRequisitos() {
        return idade > 18 && contaVogais(nome) >= 2;
    }

    private int contaVogais(String nome) {
        int count = 0;
        String vogais = "aeiouAEIOU";
        for (char c : nome.toCharArray()) {
            if (vogais.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Idade: " + idade + ", Email: " + email;
    }
}

public class FilaCircularUsuarios {
    private Usuario[] fila;
    private int front;
    private int rear;
    private int capacidade;
    private int tamanho;

    public FilaCircularUsuarios(int capacidade) {
        this.capacidade = capacidade;
        fila = new Usuario[capacidade];
        front = rear = -1;
        tamanho = 0;
    }

    public boolean cheia() {
        return tamanho == capacidade;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public void enqueue(Usuario usuario) { //Adicionar
        if (cheia()) {
            System.out.println("Fila cheia! Não foi possível adicionar: " + usuario.nome);
            return;
        }
        if (vazia()) {
            front = 0;
        }
        rear = (rear + 1) % capacidade;
        fila[rear] = usuario;
        tamanho++;
        System.out.println("Usuário adicionado: " + usuario);
    }

    public void dequeue() { //Remover
        if (vazia()) {
            System.out.println("Fila vazia! Nada para remover.");
            return;
        }
        System.out.println("Removendo usuário: " + fila[front]);
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacidade;
        }
        tamanho--;
    }

    public void exibirFila() {
        if (vazia()) {
            System.out.println("Fila vazia!");
            return;
        }
        System.out.println("Fila Atual:");
        int i = front;
        for (int count = 0; count < tamanho; count++) {
            System.out.println(fila[i]);
            i = (i + 1) % capacidade;
        }
    }

    public static Usuario gerarUsuarioAleatorio(int id) {
        String[] nomes = {"João", "Ana", "Carlos", "Beatriz", "Ricardo", "Mateus", "Lucas", "Maria", "Juliana", "Fernanda"};
        Random rand = new Random();
        String nome = nomes[rand.nextInt(nomes.length)];
        int idade = rand.nextInt(10) + 18; // Gera idade entre 18 e 27
        String email = nome.toLowerCase() + id + "@exemplo.com";
        return new Usuario(id, nome, idade, email);
    }

    public static void main(String[] args) {
        FilaCircularUsuarios fila = new FilaCircularUsuarios(5);
        Random rand = new Random();

        for (int i = 1; i <= 10; i++) {
            Usuario usuario = gerarUsuarioAleatorio(i);
            if (usuario.atendeRequisitos()) {
                fila.enqueue(usuario);
            }
        }

        fila.exibirFila();
        System.out.println("\nRemovendo usuários...");
        while (!fila.vazia()) {
            fila.dequeue();
            fila.exibirFila();
        }
    }
}
