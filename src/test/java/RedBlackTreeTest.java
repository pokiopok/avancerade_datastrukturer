import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {


    Integer[] sorted = new Integer[]{1,2,3,4,5,6,7,8,9};


    @Test
    void insert() {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert(1);
        assertTrue(redBlackTree.contains(1));
    }

    @Test
    void insertSorted() {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        for(Integer i : sorted){
            redBlackTree.insert(i);
        }
        assertTrue(redBlackTree.contains(3));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        printTree();
        redBlackTree.insert(1);
        printTree();
        assertTrue(redBlackTree.contains(1));
        redBlackTree.remove(1);
        printTree();
        assertTrue(!redBlackTree.contains(1));
    }

    @org.junit.jupiter.api.Test
    void findMin() {
    }

    @org.junit.jupiter.api.Test
    void findMax() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void makeEmpty() {
    }

    @org.junit.jupiter.api.Test
    void printTree() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }
}