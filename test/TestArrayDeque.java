package test;
import org.junit.jupiter.api.Test;
import src.ArrayDeque;


public class TestArrayDeque {

    @Test
    public void test_add_first() {
        ArrayDeque<Integer> node = new ArrayDeque<>();
        node.addFirst(1);
        assert  node.size() == 1;
    }


    @Test
    public void test_add_last() {
        ArrayDeque<Integer> node = new ArrayDeque<>();
        node.addLast(1);
        node.addLast(2);
        assert  node.size() == 2;
    }


    @Test
    public void test_is_Empty() {
        ArrayDeque<Integer> node = new ArrayDeque<>();
//        node.addLast(2);
        assert  node.isEmpty();
    }


    @Test
    public void test_print_Deque() {
        ArrayDeque<Integer> node = new ArrayDeque<>();
        node.addLast(1);
        node.addFirst(5);
        node.addLast(2);
        node.printDeque();
    }


    @Test
    public void test_remove_first() {
        ArrayDeque<Integer> node = new ArrayDeque<>();
        node.addLast(1);
        node.addFirst(5);
        node.addLast(2);
        node.removeFirst();
        node.printDeque();
    }


    @Test
    public void test_remove_last() {
        ArrayDeque<Integer> node = new ArrayDeque<>();
        node.addLast(1);
        node.addFirst(5);
        node.addLast(2);
        node.removeLast();
        node.printDeque();
    }


    @Test
    public void test_get() {
        ArrayDeque<Integer> node = new ArrayDeque<>();
        node.addLast(1);
        node.addFirst(5);
        node.addLast(2);
        assert node.get(1) == 1;
    }
}
