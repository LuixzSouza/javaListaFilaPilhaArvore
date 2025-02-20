import ListaSimples.ListaSimples;

public class App {
    public static void main(String[] args) throws Exception {
        ListaSimples lista = new ListaSimples();

        lista.add(10);
        lista.add(20);
        lista.add(30);

        lista.display();
    }
}
