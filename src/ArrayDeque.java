package src;

public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static final int RFACTOR = 2;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }


    private int plusOne(int index) {
        if (index == items.length - 1) {
            return 0;
        }
        return index + 1;
    }


    private int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        }
        return index - 1;
    }


    private void resize() {
        T[] a = (T[]) new Object[size * RFACTOR];
        int oldIndex = plusOne(nextFirst);
        for (int newIndex = 0; newIndex < size; newIndex++) {
            a[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }


    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printDeque() {
        int temp = plusOne(nextFirst);  // the first node
        for (int i = 0; i < size; i++) {
            System.out.print(items[temp] + " ");
            temp = plusOne(temp);
        }
        System.out.println();
    }


    public T removeFirst() {
        if (isEmpty()) {
            throw new java.lang.IndexOutOfBoundsException("Deque is empty");
        }
        int firstIndex = plusOne(nextFirst);
        T firstItem = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = firstIndex;
        size -= 1;
        return firstItem;
    }


    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new java.lang.IndexOutOfBoundsException("Deque is empty");
        }
        int lastIndex = minusOne(nextLast);
        T lastItem = items[lastIndex];
        items[lastIndex] = null;
        nextLast = lastIndex;
        size -= 1;
        return lastItem;
    }

    @Override
    public T get(int i) {
        if (i >= size) {
            return null;
        }
        int firstIndex = plusOne(nextFirst);
        return items[(firstIndex + i) % items.length];
    }


}
