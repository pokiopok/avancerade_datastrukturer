import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTest {


    //SplayTree splayTree;
    Integer[] sortedSmallArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] reverseSortedSmallArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    Integer[] mixedSmallArray = {4, 2, 7, 1, 5, 8, 3, 9, 6};




    @Test
    void insertSplTTest() {
        SplayTree splayTree = new SplayTree<>();
        splayTree.insert(1);
        assertEquals(true, splayTree.contains(1));
    }

    @Test
    void removeSplTest() {
        SplayTree splayTree = new SplayTree<>();
        splayTree.insert(1);
        splayTree.insert(2);
        splayTree.remove(1);
        assertEquals(false, splayTree.contains(1));
    }

    @Test
    void findMinSplT() {
        SplayTree splayTree = new SplayTree<>();
        for(int i = 0; i < sortedSmallArray.length; i++) {
            splayTree.insert(sortedSmallArray[i]);
        }
        assertEquals(1, splayTree.findMin() );
    }

    @Test
    void findMaxSplTTest() {
        SplayTree splayTree = new SplayTree<>();
        for(int i = 0; i < sortedSmallArray.length; i++) {
            splayTree.insert(sortedSmallArray[i]);
        }
        assertEquals(1, splayTree.findMin() );
    }

    @Test
    void containsSplTTest() {
        SplayTree splayTree = new SplayTree<>();
        splayTree.insert(1);
        assertEquals(true, splayTree.contains(1));
    }

    @Test
    void makeEmpty() {
    }

    @Test
    void isEmpty() {

    }
}