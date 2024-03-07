import java.util.ArrayList;
import java.util.Random;

public class Main {

    Random random = new Random();

    RedBlackTree<Integer> rb;
    SplayTree<Integer> st;
    Treap<Integer> tr;

    Integer min = Integer.MIN_VALUE;
    Integer max = Integer.MAX_VALUE;
    Integer[] sortedSmallArray = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] reverseSortedSmallArray = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2};
    Integer[] mixedSmallArray = {4, 2, 0, 7, 1, 11, 5, 8, 3, 10, 9, 6};
    Integer[] mixedWithDoubles = {3, 1, 5, 7, 3, 2, 3, 1, 8, 6, 9, 3};
    ArrayList<Integer> randomMixedMiddleSized = new ArrayList<>();
    ArrayList<Integer> randomExtremeValues = new ArrayList<>();
    ArrayList<Integer> randomBigArray = new ArrayList<>();
    ArrayList<Integer> randomBigArrayWithDoubles = new ArrayList<>();

    public Main(){
        populateRandomArrays();
    }
    private void populateRandomArrays(){
        ArrayList<Integer> used = new ArrayList<>();
        for(int i=0; i<850; i++){
            randomMixedMiddleSized.add(random.nextInt());
        }

        for(int i=0; i<12; i++){
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
                i++;
            }
        }


    }
    private void populateByDemand(Integer[] inputArray){
        rb = new RedBlackTree<>();
        st = new SplayTree<>();
        tr = new Treap<>();

        for (Integer integer : inputArray) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
    }
    private void populateByDemand(ArrayList<Integer> inputArray){
        rb = new RedBlackTree<>();
        st = new SplayTree<>();
        tr = new Treap<>();

        for (Integer integer : inputArray) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
    }

    public void sortedSmallTest(){
        populateByDemand(sortedSmallArray);
        System.out.println("Small sorted list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void reverseSortedSmallTest(){
        populateByDemand(reverseSortedSmallArray);
        System.out.println("Small reverse sorted list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void mixedSmallTest(){
        populateByDemand(mixedSmallArray);
        System.out.println("Small mixed list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void mixedSmallDoublesTest(){
        populateByDemand(mixedWithDoubles);
        System.out.println("Small mixed list with doubles rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void randomExtremeTest(){
        populateByDemand(randomExtremeValues);
        System.out.println("Random extreme values list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void randomBigSinglesTest(){
        populateByDemand(randomBigArray);
        System.out.println("Big random single values list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }
    public void randomBigDoublesTest(){
        populateByDemand(randomBigArrayWithDoubles);
        System.out.println("Big random doubles values list rotation count");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }

    public void firstAddThenRemoveTest(){
        populateByDemand(randomMixedMiddleSized);
        do{
            int index = random.nextInt(randomMixedMiddleSized.size());
            st.remove(randomMixedMiddleSized.get(index));
            randomMixedMiddleSized.remove(index);
        }while(randomMixedMiddleSized.size()>0);
        System.out.println("First add and then remove whole list rotation count - 850 elements");
        System.out.println("    RedBlack: " + rb.getCounter());
        System.out.println("    SplayTree: " + st.getCounter());
        System.out.println("    Treap: " + tr.getCounter());
    }

    public void mixedAddAndRemoveTest(){
        rb = new RedBlackTree<>();
        st = new SplayTree<>();
        tr = new Treap<>();

        for(int i=0; i<=1700;i++){

        }


        for (Integer integer : randomMixedMiddleSized) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
        do{
            int index = random.nextInt(randomMixedMiddleSized.size());
            st.remove(randomMixedMiddleSized.get(index));
            randomMixedMiddleSized.remove(index);
        }while(randomMixedMiddleSized.size()>0);
        System.out.println("First add and then remove whole list rotation count - ");
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
        main.firstAddThenRemoveTest();


    }
}
