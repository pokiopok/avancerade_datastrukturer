import java.util.ArrayList;
import java.util.Random;

public class Main {

    Random random = new Random();
    Integer min = Integer.MIN_VALUE;
    Integer max = Integer.MAX_VALUE;
    Integer[] sortedSmallArray = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] reverseSortedSmallArray = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2};
    Integer[] mixedSmallArray = {4, 2, 7, 1, 5, 8, 3, 9, 6};
    Integer[] mixedWithDoubles = {3, 1, 5, 7, 3, 2, 3, 1, 8, 6, 9, 3, 2, 5, 1, 7};
    ArrayList<Integer> randomExtremeValues = new ArrayList<>();
    ArrayList<Integer> randomBigArray = new ArrayList<>();
    ArrayList<Integer> randomBigArrayWithDoubles = new ArrayList<>();

    public Main(){
        populateRandomArrays();
    }
    private void populateRandomArrays(){
        ArrayList<Integer> used = new ArrayList<>();
        for(int i=0; i<12345; i++){
            Integer difference = random.nextInt(1000);
            if(random.nextBoolean()){
                randomExtremeValues.add(min-difference);
            } else {
                randomExtremeValues.add(max-difference);
            }
        }

        for(int i=0; i<12345; i++){
            Integer newInt = random.nextInt();
            if(!used.contains(newInt)){
                used.add(newInt);
                randomBigArray.add(newInt);
            }
        }

        for(int i=0; i<12345; i++){
            Integer newInt = random.nextInt();
            if(!used.contains(newInt)){
                used.add(newInt);
                randomBigArrayWithDoubles.add(newInt);
            }
            if(random.nextBoolean()){
                randomBigArrayWithDoubles.add(used.get(i % used.size()));
            }
        }


    }

    public void sortedSmallTest(){
        RedBlackTree<Integer> rb = new RedBlackTree<>();
        SplayTree<Integer> st = new SplayTree<>();
        Treap<Integer> tr = new Treap<>();

        for (Integer integer : sortedSmallArray) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
        System.out.println("Small sorted list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void reverseSortedSmallTest(){
        RedBlackTree<Integer> rb = new RedBlackTree<>();
        SplayTree<Integer> st = new SplayTree<>();
        Treap<Integer> tr = new Treap<>();

        for (Integer integer : reverseSortedSmallArray) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
        System.out.println("Small reverse sorted list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void mixedSmallTest(){
        RedBlackTree<Integer> rb = new RedBlackTree<>();
        SplayTree<Integer> st = new SplayTree<>();
        Treap<Integer> tr = new Treap<>();

        for (Integer integer : mixedSmallArray) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
        System.out.println("Small mixed list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void mixedSmallDoublesTest(){
        RedBlackTree<Integer> rb = new RedBlackTree<>();
        SplayTree<Integer> st = new SplayTree<>();
        Treap<Integer> tr = new Treap<>();

        for (Integer integer : mixedWithDoubles) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
        System.out.println("Small mixed list with doubles rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void randomExtremeTest(){
        RedBlackTree<Integer> rb = new RedBlackTree<>();
        SplayTree<Integer> st = new SplayTree<>();
        Treap<Integer> tr = new Treap<>();

        for (Integer integer : randomExtremeValues) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
        System.out.println("Random extreme values list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void randomBigSinglesTest(){
        RedBlackTree<Integer> rb = new RedBlackTree<>();
        SplayTree<Integer> st = new SplayTree<>();
        Treap<Integer> tr = new Treap<>();

        for (Integer integer : randomBigArray) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
        System.out.println("Big random single values list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void randomBigDoublesTest(){
        RedBlackTree<Integer> rb = new RedBlackTree<>();
        SplayTree<Integer> st = new SplayTree<>();
        Treap<Integer> tr = new Treap<>();

        for (Integer integer : randomBigArrayWithDoubles) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
        System.out.println("Big random doubles values list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }

    public static void main(String[] args){
        Main main = new Main();

        main.sortedSmallTest();
        main.reverseSortedSmallTest();
        main.mixedSmallTest();
        main.mixedSmallDoublesTest();
        main.randomExtremeTest();
        main.randomBigSinglesTest();
        main.randomBigDoublesTest();
    }
}
