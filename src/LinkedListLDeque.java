package src;


public class LinkedListLDeque<T> implements Deque<T> {

    private class Node {
        private T item;
        private Node next;
        private Node prev;

        private Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }


    private Node sentinel;  // sentinel.next is the first node
    private int size;


    // initialize an empty deque
    public LinkedListLDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    @Override
    // add an item to the front of the deque
    public void addFirst(T item) {
        Node first = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }


    @Override
    // add an item to the back of the deque
    public void addLast(T item) {
        Node last = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }


    @Override
    // return the size of the deque
    public int size() {
        return size;
    }


    @Override
    // remove and return the first item of the deque
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size -= 1;
        return first.item;
    }


    @Override
    // remove and return the last item of the deque
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size -= 1;
        return last.item;
    }


    @Override
    // return the item at the given index
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }


    @Override
    // print the items in the deque from first to last
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }


    @Override
    // return true if the deque is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }


}
