//todo: add a double linked and use a ELEM type. √
public class DoubleLinked <ELEM>{
    private int size;
    private final Node sentinel;
    private final class Node{
        private ELEM item;
        private Node next;
        private Node prev;
        public Node(ELEM i, Node n, Node p){
            item = i;
            next = n;
            prev = p;
        }
    }
    public DoubleLinked(){
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    public DoubleLinked(ELEM x){
        size = 1;
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
    }

    public void addfirst(ELEM x){
        Node p = new Node(x, sentinel.next, sentinel);
        sentinel.next.prev = p;
        sentinel.next = p;
        size += 1;
    }

    public void addlast(ELEM x){
        Node p = new Node(x, sentinel, sentinel.prev);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    public void show_item(){
        Node p = sentinel.next;
        while(p != sentinel){
            System.out.print(p.item);
            if (p.next != sentinel) {
                System.out.print("->");
            }else{
                System.out.println();
            }
            p = p.next;
        }
    }

    public int size(){
        return this.size;
    }

    public void addindex(ELEM x, int index){
        if (index > size || index <= 0) {
            System.out.println("index out of range");
            return;
        }
        Node p = sentinel;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node newnode = new Node(x, p, p.prev);
        newnode.next.prev = newnode;
        newnode.prev.next = newnode;
        size += 1;
    }

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        DoubleLinked<Character> L = new DoubleLinked<>('a');
        L.addfirst('b');
        L.addlast('c');
        L.addindex('d', 3);
        System.out.println(L.size());
        L.show_item();
    }

}
