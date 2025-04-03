package ScriptAulas;

public class Atividade1 {
    import java.util.LinkedList;
import java.util.Queue;
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

    public boolean atendeCondicao() {
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

class FilaUsuarios {
    private Queue<Usuario> fila = new LinkedList<>();
    private static final int MAX_SIZE = 5;

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public boolean estaCheia() {
        return fila.size() >= MAX_SIZE;
    }

    public void inserir(Usuario usuario) {
        if (!estaCheia() && usuario.atendeCondicao()) {
            fila.add(usuario);
            System.out.println("Usuário inserido: " + usuario);
        } else {
            System.out.println("Usuário não inserido (fila cheia ou não atende condições): " + usuario);
        }
    }

    public void remover() {
        if (!estaVazia()) {
            Usuario removido = fila.poll();
            System.out.println("Usuário removido: " + removido);
        } else {
            System.out.println("Fila vazia! Nada para remover.");
        }
    }

    public void imprimirFila() {
        System.out.println("Fila Atual: " + fila);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] nomes = {"João", "Ana", "Carlos", "Beatriz", "Ricardo", "Mateus", "Lucas", "Maria", "Juliana", "Fernanda"};
        Random random = new Random();
        FilaUsuarios filaUsuarios = new FilaUsuarios();

        for (int i = 1; i <= 10; i++) {
            String nome = nomes[random.nextInt(nomes.length)];
            int idade = 18 + random.nextInt(10);
            String email = nome.toLowerCase() + i + "@exemplo.com";
            Usuario usuario = new Usuario(i, nome, idade, email);
            filaUsuarios.inserir(usuario);
        }

        filaUsuarios.imprimirFila();
        while (!filaUsuarios.estaVazia()) {
            filaUsuarios.remover();
            filaUsuarios.imprimirFila();
        }
    }
}

}
