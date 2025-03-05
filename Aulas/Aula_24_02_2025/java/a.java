package Aulas.Aula_24_02_2025.java;
\
public class a {

    // ============================
    // FUNÇÕES AUXILIARES
    // ============================
    public static boolean isPar(int valor) {
        return valor % 2 == 0;
    }
    
    public static boolean isImpar(int valor) {
        return !isPar(valor);
    }
    
    
    // ============================
    // LISTA SIMPLES ENCadeada (Números inteiros)
    // ============================
    static class NoSimples {
        int dado;
        NoSimples proximo;
        
        public NoSimples(int dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }
    
    static class ListaSimples {
        NoSimples primeiro;
        
        public ListaSimples() {
            this.primeiro = null;
        }
        
        // Insere um novo nó no final
        public void inserir(int dado) {
            NoSimples novo = new NoSimples(dado);
            if (primeiro == null) {
                primeiro = novo;
            } else {
                NoSimples atual = primeiro;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novo;
            }
        }
        
        // Remove o primeiro nó que contenha o valor informado
        public boolean remover(int dado) {
            if (primeiro == null)
                return false;
            if (primeiro.dado == dado) {
                primeiro = primeiro.proximo;
                return true;
            }
            NoSimples atual = primeiro;
            while (atual.proximo != null) {
                if (atual.proximo.dado == dado) {
                    atual.proximo = atual.proximo.proximo;
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }
        
        // Busca um nó com o valor informado
        public NoSimples buscar(int dado) {
            NoSimples atual = primeiro;
            while (atual != null) {
                if (atual.dado == dado)
                    return atual;
                atual = atual.proximo;
            }
            return null;
        }
        
        // Conta o número de nós na lista
        public int contar() {
            int cont = 0;
            NoSimples atual = primeiro;
            while (atual != null) {
                cont++;
                atual = atual.proximo;
            }
            return cont;
        }
        
        // Imprime a lista
        public void imprimir() {
            NoSimples atual = primeiro;
            while (atual != null) {
                System.out.print(atual.dado + " -> ");
                atual = atual.proximo;
            }
            System.out.println("null");
        }
    }

    static class NoSimples<T> {
        T dado;
        NoSimples<T> proximo;
    
        public NoSimples(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }
    static class NoDuplo<T> {
        T dado;
        NoDuplo<T> proximo, anterior;
    
        public NoDuplo(T dado) {
            this.dado = dado;
            this.proximo = null;
            this.anterior = null;
        }
    }
    
    
    
    
    // ============================
    // LISTA DUPLAMENTE ENCadeada (Números inteiros)
    // ============================
    static class NoDuplo {
        int dado;
        NoDuplo proximo, anterior;
        
        public NoDuplo(int dado) {
            this.dado = dado;
            this.proximo = null;
            this.anterior = null;
        }
    }
    
    static class ListaDupla {
        NoDuplo primeiro, ultimo;
        
        public ListaDupla() {
            primeiro = null;
            ultimo = null;
        }
        
        // Insere um novo nó:
        // Se o valor for par, insere no início;
        // Se for ímpar, insere no final.
        public void inserir(int dado) {
            NoDuplo novo = new NoDuplo(dado);
            if (primeiro == null) {
                primeiro = ultimo = novo;
            } else {
                if (isPar(dado)) { // Valor par: insere no início
                    novo.proximo = primeiro;
                    primeiro.anterior = novo;
                    primeiro = novo;
                } else { // Valor ímpar: insere no final
                    ultimo.proximo = novo;
                    novo.anterior = ultimo;
                    ultimo = novo;
                }
            }
        }
        
        // Remove o primeiro nó com o valor informado
        public boolean remover(int dado) {
            if (primeiro == null)
                return false;
            if (primeiro.dado == dado) {
                primeiro = primeiro.proximo;
                if (primeiro != null)
                    primeiro.anterior = null;
                else
                    ultimo = null;
                return true;
            }
            NoDuplo atual = primeiro;
            while (atual != null) {
                if (atual.dado == dado) {
                    if (atual.proximo != null) {
                        atual.proximo.anterior = atual.anterior;
                    } else {
                        ultimo = atual.anterior;
                    }
                    if (atual.anterior != null) {
                        atual.anterior.proximo = atual.proximo;
                    }
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }
        
        // Busca um nó com o valor informado
        public NoDuplo buscar(int dado) {
            NoDuplo atual = primeiro;
            while (atual != null) {
                if (atual.dado == dado)
                    return atual;
                atual = atual.proximo;
            }
            return null;
        }
        
        // Conta os nós da lista
        public int contar() {
            int cont = 0;
            NoDuplo atual = primeiro;
            while (atual != null) {
                cont++;
                atual = atual.proximo;
            }
            return cont;
        }
        
        // Imprime a lista do início ao fim
        public void imprimir() {
            NoDuplo atual = primeiro;
            while (atual != null) {
                System.out.print(atual.dado + " <-> ");
                atual = atual.proximo;
            }
            System.out.println("null");
        }
        
        // Imprime a lista do fim ao início (modo reverso)
        public void imprimirReverso() {
            NoDuplo atual = ultimo;
            while (atual != null) {
                System.out.print(atual.dado + " <-> ");
                atual = atual.anterior;
            }
            System.out.println("null");
        }
    }
    
    
    // ============================
    // EXEMPLO DE USO DAS FUNÇÕES
    // ============================
    public static void main(String[] args) {
        System.out.println("=== Lista Simples ===");
        ListaSimples listaSimples = new ListaSimples();
        // Chamadas de funções prontas:
        listaSimples.inserir(5);
        listaSimples.inserir(10);
        listaSimples.inserir(3);
        
        listaSimples.imprimir();
        System.out.println("Busca 10: " + (listaSimples.buscar(10) != null ? "Encontrado" : "Não encontrado"));
        listaSimples.remover(5);
        listaSimples.imprimir();
        System.out.println("Total de nós: " + listaSimples.contar());
        
        System.out.println("\n=== Lista Duplamente Encadeada ===");
        ListaDupla listaDupla = new ListaDupla();
        // Chamadas de funções prontas com regra par/ímpar:
        listaDupla.inserir(4);  // Par -> insere no início
        listaDupla.inserir(7);  // Ímpar -> insere no final
        listaDupla.inserir(2);  // Par -> insere no início
        listaDupla.inserir(9);  // Ímpar -> insere no final
        listaDupla.inserir(6);  // Par -> insere no início
        
        listaDupla.imprimir();
        System.out.println("Busca 9: " + (listaDupla.buscar(9) != null ? "Encontrado" : "Não encontrado"));
        listaDupla.remover(7);
        listaDupla.imprimir();
        System.out.println("Total de nós: " + listaDupla.contar());
        System.out.println("Lista reversa:");
        listaDupla.imprimirReverso();
    }
}

