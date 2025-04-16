public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

Conceitos Básicos
Pilha (Stack): Estrutura LIFO (Last In, First Out); o último elemento inserido é o primeiro a ser removido.

Operações principais:
push(T elemento): Insere um elemento no topo.
pop(): Remove e retorna o elemento do topo.
peek(): Retorna o elemento do topo sem removê-lo.
isEmpty(): Verifica se a pilha está vazia.
tamanho(): Retorna o número de elementos na pilha.
imprimir(): Exibe os elementos (normalmente do topo para a base).

public class Pilha<T> {
    private Object[] elementos;
    private int topo;
    private int capacidade;

    // Construtor: inicializa com capacidade e pilha vazia (topo = -1)
    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Object[capacidade];
        this.topo = -1;
    }

    // Empilhar: insere elemento no topo, se houver espaço
    public void push(T elemento) {
        if (topo == capacidade - 1) {
            System.out.println("Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    // Desempilhar: remove e retorna o elemento do topo
    public T pop() {
        if (topo == -1) throw new EmptyStackException();
        T removido = (T) elementos[topo];
        elementos[topo--] = null;
        return removido;
    }

    // Verificar o topo: retorna o elemento do topo sem remover
    public T peek() {
        if (topo == -1) throw new EmptyStackException();
        return (T) elementos[topo];
    }

    // Verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Tamanho: retorna a quantidade de elementos na pilha
    public int tamanho() {
        return topo + 1;
    }

    // Imprimir: exibe os elementos do topo para a base
    public void imprimir() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return;
        }
        System.out.println("Conteúdo da pilha:");
        for (int i = topo; i >= 0; i--) {
            System.out.println(elementos[i]);
        }
    }
}

public static void main(String[] args) {
    Pilha<Integer> pilha = new Pilha<>(5);

    pilha.push(10);
    pilha.push(20);
    pilha.push(30);
    pilha.push(40);
    pilha.push(50);
    pilha.push(60); // Não insere, pois a pilha está cheia

    pilha.imprimir();
    System.out.println("Topo: " + pilha.peek());
    System.out.println("Removido: " + pilha.pop());
    System.out.println("Tamanho atual: " + pilha.tamanho());
    
    while (!pilha.isEmpty()) {
        System.out.println("Removido: " + pilha.pop());
    }
    
    // Tratamento de exceção para pilha vazia:
    try {
        pilha.peek();
    } catch (EmptyStackException e) {
        System.out.println("Erro: Pilha vazia!");
    }
}


Utilizando a Classe Stack do Java
Principais métodos:
push(E item): Insere o item.
pop(): Remove e retorna o item do topo.
peek(): Retorna o item do topo.
isEmpty(): Verifica se a pilha está vazia.

import java.util.Stack;

public class PilhaExemplo {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Topo: " + pilha.peek());
        System.out.println("Removido: " + pilha.pop());
        System.out.println("Novo topo: " + pilha.peek());
        System.out.println("Pilha vazia? " + pilha.isEmpty());
    }
}

Utilizando Deque com ArrayDeque
Vantagens:
Melhor performance em operações de pilha e fila.

Métodos similares: push, pop, peek, isEmpty.

import java.util.Deque;
import java.util.ArrayDeque;

public class PilhaComDeque {
    public static void main(String[] args) {
        Deque<Integer> pilha = new ArrayDeque<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Topo: " + pilha.peek());
        System.out.println("Removido: " + pilha.pop());
        System.out.println("Novo topo: " + pilha.peek());
        System.out.println("Pilha vazia? " + pilha.isEmpty());
    }
}

// Empilhar números pares ou ímpares:
public void empilharSePar(int num) {
    if (num % 2 == 0) {
        pilhaNumeros.push(num);
    }
}

//Empilhar se o número for maior que um valor específico:
public void empilharSeMaiorQue(int num, int valor) {
    if (num > valor) {
        pilhaNumeros.push(num);
    }
}


//Empilhar palavras que contenham pelo menos uma vogal:
public boolean possuiVogal(String palavra) {
    return palavra.toLowerCase().matches(".*[aeiou].*");
}

public void empilharSePossuiVogal(String palavra) {
    if (possuiVogal(palavra)) {
        pilhaPalavras.push(palavra);
    }
}

// Empilhar Apenas Números Primos
public boolean isPrimo(int num) {
    if (num < 2) return false;
    for (int i = 2; i <= Math.sqrt(num); i++) {
        if (num % i == 0) return false;
    }
    return true;
}

public void empilharSePrimo(int num) {
    if (isPrimo(num)) {
        pilhaNumeros.push(num);
    }
}


// Empilhar Palavras Palíndromas
public boolean isPalindromo(String palavra) {
    String reverso = new StringBuilder(palavra).reverse().toString();
    return palavra.equalsIgnoreCase(reverso);
}

public void empilharSePalindromo(String palavra) {
    if (isPalindromo(palavra)) {
        pilhaPalavras.push(palavra);
    }
}

package pilha;

import java.util.Deque;
import java.util.ArrayDeque;

public class PilhaComDeque {
    public static void main(String[] args) {
        Deque<Integer> pilha = new ArrayDeque<>();
        
        // Adicionando elementos na pilha
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        // Imprimindo o topo da pilha
        System.out.println("Topo da pilha: " + pilha.peek());
        
        // Removendo o topo da pilha
        System.out.println("Removido: " + pilha.pop());
        
        // Verificando o novo topo
        System.out.println("Novo topo da pilha: " + pilha.peek());
        
        // Verificando se a pilha está vazia
        System.out.println("A pilha está vazia? " + pilha.isEmpty());
    }
}

import java.util.Stack;

public class PilhaExemplo {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        
        // Adicionando elementos na pilha
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        // Imprimindo o topo da pilha
        System.out.println("Topo da pilha: " + pilha.peek());
        
        // Removendo o topo da pilha
        System.out.println("Removido: " + pilha.pop());
        
        // Verificando o novo topo
        System.out.println("Novo topo da pilha: " + pilha.peek());
        
        // Verificando se a pilha está vazia
        System.out.println("A pilha está vazia? " + pilha.isEmpty());
    }
}

import java.util.EmptyStackException;

public class PilhaExemploFull {

    // Definindo uma classe Pilha
    static class Pilha<T> {
        // O array para armazenar os elementos da pilha
        private Object[] elementos;
        private int topo; // índice do topo da pilha
        private int capacidade; // capacidade máxima da pilha

        // Construtor da pilha com uma capacidade inicial
        public Pilha(int capacidade) {
            this.capacidade = capacidade;
            this.elementos = new Object[capacidade];
            this.topo = -1; // Inicialmente, a pilha está vazia
        }

        // Método para inserir um elemento na pilha (push)
        public void push(T elemento) {
            // Verificando se a pilha está cheia
            if (topo == capacidade - 1) {
                System.out.println("Pilha cheia! Não é possível inserir mais elementos.");
                return;
            }
            elementos[++topo] = elemento; // Inserindo no topo da pilha
            System.out.println("Elemento inserido: " + elemento);
        }

        // Método para remover um elemento da pilha (pop)
        public T pop() {
            // Verificando se a pilha está vazia
            if (topo == -1) {
                throw new EmptyStackException(); // Lançando exceção se a pilha estiver vazia
            }
            T elementoRemovido = (T) elementos[topo]; // Pegando o elemento do topo
            elementos[topo--] = null; // Desreferenciando o elemento removido
            return elementoRemovido; // Retornando o elemento removido
        }

        // Método para ver o elemento no topo da pilha (peek)
        public T peek() {
            // Verificando se a pilha está vazia
            if (topo == -1) {
                throw new EmptyStackException(); // Lançando exceção se a pilha estiver vazia
            }
            return (T) elementos[topo]; // Retorna o topo sem remover
        }

        // Método para verificar se a pilha está vazia
        public boolean isEmpty() {
            return topo == -1; // Se o topo for -1, significa que a pilha está vazia
        }

        // Método para imprimir todos os elementos da pilha
        public void imprimir() {
            // Verificando se a pilha está vazia
            if (isEmpty()) {
                System.out.println("A pilha está vazia!");
                return;
            }
            System.out.println("Conteúdo da pilha: ");
            for (int i = topo; i >= 0; i--) {
                System.out.println(elementos[i]);
            }
        }

        // Método para retornar o tamanho atual da pilha
        public int tamanho() {
            return topo + 1; // O topo indica a quantidade de elementos
        }
    }

    public static void main(String[] args) {
        // Criando uma pilha de inteiros com capacidade 5
        Pilha<Integer> pilha = new Pilha<>(5);

        // Inserindo elementos na pilha
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);
        
        // Tentando inserir um elemento na pilha cheia
        pilha.push(60); // Este elemento não será inserido, pois a pilha já está cheia

        // Imprimindo o conteúdo da pilha
        pilha.imprimir();

        // Verificando o topo da pilha
        System.out.println("\nTopo da pilha: " + pilha.peek());

        // Removendo um elemento da pilha
        System.out.println("\nElemento removido: " + pilha.pop());

        // Imprimindo o conteúdo da pilha após remoção
        pilha.imprimir();

        // Verificando o tamanho atual da pilha
        System.out.println("\nTamanho atual da pilha: " + pilha.tamanho());

        // Removendo todos os elementos até a pilha ficar vazia
        System.out.println("\nRemovendo todos os elementos:");
        while (!pilha.isEmpty()) {
            System.out.println("Elemento removido: " + pilha.pop());
        }

        // Tentando acessar o topo de uma pilha vazia (vai lançar exceção)
        try {
            pilha.peek();
        } catch (EmptyStackException e) {
            System.out.println("\nErro: Pilha vazia! Não é possível acessar o topo.");
        }
    }
}

// Desafio: Desempilhamento de Palavras com Deque
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class DesempilhamentoPalavras {

    // Pilha de palavras com Deque
    private Deque<String> pilha = new ArrayDeque<>();

    // Empilha uma palavra
    public void empilharPalavra(String palavra) {
        pilha.push(palavra);
    }

    // Desempilha e imprime as palavras (ordem inversa)
    public void desempilharPalavras() {
        System.out.println("\nDesempilhando palavras:");
        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

    // Retorna o tamanho da pilha
    public int tamanhoDaPilha() {
        return pilha.size();
    }

    // Imprime a pilha da base até o topo
    public void imprimirPilha() {
        if (pilha.isEmpty()) {
            System.out.println("A pilha está vazia!");
            return;
        }
        System.out.println("\nPalavras na pilha (da base para o topo):");
        pilha.descendingIterator().forEachRemaining(System.out::println);
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DesempilhamentoPalavras programa = new DesempilhamentoPalavras();

        System.out.println("Digite palavras para empilhar (digite 'sair' para finalizar):");
        while (true) {
            String palavra = scanner.nextLine();
            if (palavra.equalsIgnoreCase("sair")) break;
            programa.empilharPalavra(palavra);
        }

        programa.imprimirPilha(); // Mostra a pilha
        System.out.println("\nTamanho da pilha: " + programa.tamanhoDaPilha());

        programa.desempilharPalavras(); // Desempilha e imprime
    }
}

//Verificador de Palindromo com DEQUE
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class VerificadorDePalindromo {

    public static boolean ehPalindromo(String palavra) {
        Deque<Character> deque = new ArrayDeque<>();

        // Adiciona cada caractere ao deque
        for (char c : palavra.toCharArray()) {
            deque.add(c);
        }

        // Verifica se os caracteres das extremidades são iguais
        while (deque.size() > 1) {
            char inicio = deque.removeFirst();
            char fim = deque.removeLast();

            if (inicio != fim) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada;

        System.out.print("Digite uma palavra (ou 'sair' para encerrar): ");
        while (!(entrada = scanner.nextLine().toLowerCase()).equals("sair")) {
            if (ehPalindromo(entrada)) {
                System.out.println("É palíndromo!");
            } else {
                System.out.println("Não é palíndromo.");
            }

            System.out.print("\nDigite outra palavra (ou 'sair' para encerrar): ");
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}


// Separador de Pares e Impares com Deque
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ParOuImparComDeque {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> numeros = new ArrayDeque<>();

        String entrada;
        System.out.println("Digite números inteiros (digite 'sair' para encerrar):");

        while (true) {
            System.out.print("Número: ");
            entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                int numero = Integer.parseInt(entrada);
                if (numero % 2 == 0) {
                    numeros.addFirst(numero); // pares na frente
                } else {
                    numeros.addLast(numero); // ímpares no final
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro ou 'sair'.");
            }
        }

        System.out.println("\nNúmeros separados (pares na frente, ímpares no final):");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        scanner.close();
    }
}


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;
    boolean vip;

    public Pessoa(String nome, int idade, boolean vip) {
        this.nome = nome;
        this.idade = idade;
        this.vip = vip;
    }

    @Override
    public String toString() {
        return nome + " - " + idade + " anos - " + (vip ? "VIP" : "Comum");
    }
}

public class FilaPrioridade {
    public static void main(String[] args) {
        Deque<Pessoa> fila = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Digite o nome (ou 'sair' para encerrar): ");
            String nome = sc.nextLine();
            if (nome.equalsIgnoreCase("sair")) break;

            System.out.print("Idade: ");
            int idade = Integer.parseInt(sc.nextLine());

            System.out.print("É VIP? (s/n): ");
            boolean vip = sc.nextLine().equalsIgnoreCase("s");

            Pessoa novaPessoa = new Pessoa(nome, idade, vip);

            // Adiciona com base na prioridade
            if (vip && idade >= 60) {
                fila.addFirst(novaPessoa); // VIP + idoso → início da fila
            } else if (vip) {
                // Procura a posição após os VIPs idosos
                boolean inserido = false;
                for (Pessoa p : fila) {
                    if (!(p.vip && p.idade >= 60)) {
                        fila.add(fila.indexOf(p), novaPessoa);
                        inserido = true;
                        break;
                    }
                }
                if (!inserido) fila.addLast(novaPessoa);
            } else if (idade >= 60) {
                // Procura depois de todos os VIPs
                boolean inserido = false;
                for (Pessoa p : fila) {
                    if (!p.vip) {
                        fila.add(fila.indexOf(p), novaPessoa);
                        inserido = true;
                        break;
                    }
                }
                if (!inserido) fila.addLast(novaPessoa);
            } else {
                fila.addLast(novaPessoa); // jovem comum → final da fila
            }

            System.out.println("\nFila atual:");
            for (Pessoa p : fila) {
                System.out.println(p);
            }
            System.out.println("----------\n");
        }

        System.out.println("\nAtendendo pessoas da fila:");
        while (!fila.isEmpty()) {
            System.out.println("Atendendo: " + fila.pollFirst());
        }

        sc.close();
    }
}
