package test;

import org.junit.jupiter.api.Test;
import src.DoubleLinked;

import java.util.Arrays;

public class TestDoubleLinked {

    @Test
    public void test_add_first() {
        DoubleLinked<Integer> test_node = new DoubleLinked<>(5);
        test_node.add_first(4);
        test_node.add_first(3);
        assert test_node.size() == 3;
    }

    @Test
    public void test_add_last() {
        DoubleLinked<Integer> test_node = new DoubleLinked<>(5);
        test_node.add_last(6);
        test_node.add_last(7);
        assert test_node.size() == 3;
    }

    @Test
    public void test_get_item() {
        DoubleLinked<Integer> test_node = new DoubleLinked<>(5);
        test_node.add_first(4);
        test_node.add_first(3);
        assert test_node.get_item(0) == 3;
        test_node.add_last(6);
        assert test_node.get_item(3) == 6;
    }

    @Test
    public void test_show_items() {
        DoubleLinked<Integer> test_node = new DoubleLinked<>(5);
        test_node.add_first(4);
        test_node.add_first(3);
        test_node.add_last(6);
        test_node.show_items();  // [3, 4, 5, 6]
    }
}
