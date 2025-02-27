package desafio;

class No {
    // Propriedades
    int dado;
    No proximo;

    // Construtor
    public No(int dado){
        this.dado = dado;
        this.proximo = null;
    }
}

public class ListaSimplesDesafio {
    No cabeca;

    // Classe com variavel Cabeça, inicializando com null
    public ListaSimplesDesafio() {
        this.cabeca = null;
    }

    public void inserirNoInicio(int dado) {
        No newNo = new No(dado);
        // Caso Não tenha nda dentro recebe o valor
        if (cabeca == null) {
            cabeca = newNo;
        } else {
            No temp = cabeca;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = newNo;
        }
    }

    public void imprimirLista() {
        // Adicionando temporario para nãO perder a referencia
        No temp = cabeca;
        while (temp != null) {
            System.out.print(temp.dado + " -> " );
            temp = temp.proximo;
        } 
        System.out.println("NULL");
    }
    
    public boolean isEmpty() {
        No temp = cabeca;
        if (temp == null) {
            System.out.println("Vazia");;
            return true;
        } else {
            System.out.println("Cheia");
            return false;
        }
    }

    // Operações avançadas
    // removerDoInicio()
    // buscarElemento()

    // Desafio Extra
    // reverterLista()
}
