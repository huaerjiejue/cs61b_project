package test;

import org.junit.jupiter.api.Test;
import src.LinkedListLDeque;

public class TestLinkedListDeque {

    @Test
    public void test_add_first() {
        LinkedListLDeque<Integer> test_node = new LinkedListLDeque<>();
        test_node.addFirst(4);
        test_node.addFirst(3);
        assert test_node.size() == 2;
    }


    @Test
    public void test_add_last() {
        LinkedListLDeque<Integer> test_node = new LinkedListLDeque<>();
        test_node.addLast(4);
        test_node.addLast(3);
        test_node.addFirst(2);
        assert test_node.size() == 3;
    }


    @Test
    public void test_remove_first() {
        LinkedListLDeque<Integer> test_node = new LinkedListLDeque<>();
        test_node.addLast(4);
        test_node.addLast(3);
        test_node.addFirst(2);
        int removed = test_node.removeFirst();
        assert test_node.size() == 2;
        assert removed == 2;
    }


    @Test
    public void test_remove_last() {
        LinkedListLDeque<Integer> test_node = new LinkedListLDeque<>();
        test_node.addLast(4);
        test_node.addLast(3);
        test_node.addFirst(2);
        int removed = test_node.removeLast();
        assert test_node.size() == 2;
        assert removed == 3;
    }


    @Test
    public void test_get() {
        LinkedListLDeque<Integer> test_node = new LinkedListLDeque<>();
        test_node.addLast(4);
        test_node.addLast(3);
        test_node.addFirst(2);
        int get = test_node.get(1);
        assert test_node.size() == 3;
        assert get == 4;
    }


    @Test
    public void test_is_empty() {
        LinkedListLDeque<Integer> test_node = new LinkedListLDeque<>();
        test_node.addLast(4);
        test_node.addLast(3);
        test_node.addFirst(2);
        boolean empty = test_node.isEmpty();
        assert test_node.size() == 3;
        assert !empty;
    }


    @Test
    public void test_print_deque() {
        LinkedListLDeque<Integer> test_node = new LinkedListLDeque<>();
        test_node.addLast(4);
        test_node.addLast(3);
        test_node.addFirst(2);
        test_node.printDeque();
        assert test_node.size() == 3;
    }


}
