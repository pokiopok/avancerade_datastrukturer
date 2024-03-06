import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreapTest {

    Treap<Integer> treap = new Treap<>();
    Integer[] sorted = new Integer[]{1,2,3,4,5,6,7,8,9};
    @Test
    void insert() {
        for(Integer i : sorted){
            treap.insert(i);
        }
        assertTrue(treap.contains(3));
    }

    @Test
    void remove() {
    }

    @Test
    void findMin() {
    }

    @Test
    void findMax() {
    }

    @Test
    void contains() {
    }

    @Test
    void makeEmpty() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void printTree() {
    }
}