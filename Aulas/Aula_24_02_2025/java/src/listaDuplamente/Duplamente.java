package listaDuplamente;

class No {
    int id;
    String nome;
    int[] nota = {1, 2, 3};
    No anterior;
    No proximo;

    public No(int id, String nome, String contato, int[] nota) {
        this.nome = nome;
        this.nota = null;
        this.anterior = null;
        this.proximo = null;
    }
}


public class Duplamente {
    No head = new No(0, null, null, null);
    
    public class Vazio() {
        return proximo == null;
    }
    
    public void InserirNo() {
        if (Vazio()) {
            
        }
    }
}
