package src;

public class DoubleLinked<T> {
    private int size = 0;
    private Node<T> sentinel = new Node<>(null, null, null);

    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        private Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public DoubleLinked() {
        this.size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public DoubleLinked(T item) {
        this.size = 1;
        sentinel.next = new Node<>(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
    }



    public int size() {
        return size;
    }


    public void add_first(T item) {
        Node<T> new_node = new Node<>(item, sentinel.next, sentinel);
        sentinel.next.prev = new_node;
        sentinel.next = new_node;
        size++;
    }

    public void add_last(T item) {
        Node<T> new_node = new Node<>(item, sentinel, sentinel.prev);
        sentinel.prev.next = new_node;
        sentinel.prev = new_node;
        size++;
    }

    public T get_item(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = sentinel.next;  // sentinel.next is the first node, the index of which is 0
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public void show_items() {
        Node<T> current = sentinel.next;
        while (current != sentinel) {
            System.out.println(current.item);
            current = current.next;
        }
    }


    public static void main(String[] args) {
    }

}
