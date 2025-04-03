# Estruturas de Dados em Java: Lista, Fila, Pilha e Árvore

Este repositório contém implementações e explicações na aula com as principais estruturas de dados em Java, incluindo Lista, Fila, Pilha e Árvore. O objetivo é auxiliar no aprendizado dessas estruturas e demonstrar como utilizá-las em diferentes cenários.

## 📌 Estruturas de Dados Abordadas

### 🔹 Lista

As listas são coleções ordenadas de elementos, permitindo adição, remoção e iteração eficiente.
Tipos abordados:

- Lista Simplesmente Encadeada
- Lista Duplamente Encadeada
- Lista Circular

#### 📌 Exemplo de uso em Java:

``` java
import java.util.LinkedList;

public class ListaExemplo {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.addFirst("Elemento 0");
        
        System.out.println(lista);
    }
}
```

### 🔹 Fila (Queue)

Uma fila segue o princípio FIFO (First In, First Out), onde o primeiro elemento inserido é o primeiro a ser removido.

#### 📌 Exemplo de uso em Java:

``` java
import java.util.LinkedList;
import java.util.Queue;

public class FilaExemplo {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.add("Cliente 1");
        fila.add("Cliente 2");
        fila.add("Cliente 3");
        
        System.out.println("Atendendo: " + fila.poll());
        System.out.println("Próximo da fila: " + fila.peek());
    }
}
```

### 🔹 Pilha (Stack)

Uma pilha segue o princípio LIFO (Last In, First Out), onde o último elemento inserido é o primeiro a ser removido.

#### 📌 Exemplo de uso em Java:

``` java
import java.util.Stack;

public class PilhaExemplo {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Removendo: " + pilha.pop());
        System.out.println("Nova pilha: " + pilha);
    }
}
```

### 🔹 Árvore Binária (Binary Tree)

Uma árvore é uma estrutura hierárquica onde cada nó pode ter filhos. A árvore binária limita cada nó a no máximo dois filhos.

#### 📌 Exemplo de implementação básica:
 
``` java
class No {
    int valor;
    No esquerda, direita;
    
    public No(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

public class ArvoreBinaria {
    No raiz;
    
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }
    
    private No inserirRec(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }
        if (valor < raiz.valor)
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        else if (valor > raiz.valor)
            raiz.direita = inserirRec(raiz.direita, valor);
        
        return raiz;
    }
}
```

## 📚 Recursos e Referências

- Documentação oficial do Java
  - https://docs.oracle.com/en/java/
- Livros sobre estruturas de dados
  - Lógica de programação e estruturas de dados JAVA (SANDRA PUGA - GERSON RISSETTI)
  - Estruturas de dados séri livros didáticos informática ufrgs
  - Estruturas de dados algoritmos, análise da complecidade e implementações em JAVA e C/C++ (Ana Fernanda Gomes Ascencio & Graziela Santos de Araújo)

## 🚀 Como Executar os Exemplos

1. Clone este repositório:
``` github
git clone "https://github.com/seu-usuario/repositorio.git"
```
2. Abra o projeto em sua IDE Java (Eclipse, IntelliJ, VS Code, etc.)
3. Compile e execute os arquivos .java para testar as implementações

**📌 Autor: Luiz Antônio de Souza**
