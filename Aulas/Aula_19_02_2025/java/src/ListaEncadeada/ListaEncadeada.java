package ListaEncadeada;

class NodeEncadeado {
    int data;
    NodeEncadeado next;
    
    public NodeEncadeado(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ListaEncadeada {
    NodeEncadeado head;

    public ListaEncadeada() {
        this.head = null;
    }

    public void add(int data) {
        NodeEncadeado newNode = new NodeEncadeado(data);
        if(head == null) {
            head = newNode;
        } else {
            NodeEncadeado temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        NodeEncadeado temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
