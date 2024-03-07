import java.util.ArrayList;
import java.util.Random;

public class Main {

    Random random = new Random();

        //Datastructures to be tested
    RedBlackTree<Integer> rb;
    SplayTree<Integer> st;
    Treap<Integer> tr;

        //Array that holds "current" values
    ArrayList<Integer> currentElements;

    Integer min = Integer.MIN_VALUE;
    Integer max = Integer.MAX_VALUE;

        //Small input arrays (12 elements each)
    Integer[] sortedSmallInput = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] reverseSortedSmallInput = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2};
    Integer[] unsortedSmallInput = {4, 2, 0, 7, 1, 11, 5, 8, 3, 10, 9, 6};
    Integer[] unsortedWithDoubleValuesSmallInput = {3, 1, 5, 7, 3, 2, 3, 1, 8, 6, 9, 3};

        //Big input arrays (12345 elements each)
    ArrayList<Integer> sortedBigInput = new ArrayList<>();
    ArrayList<Integer> reverseSortedBigInput = new ArrayList<>();
    ArrayList<Integer> unsortedBigSingleValuesInput = new ArrayList<>();
    ArrayList<Integer> unsortedExtremeValuesBigInput = new ArrayList<>();
    ArrayList<Integer> unsortedBigDoubleValuesInput = new ArrayList<>();

        //Base case input array (850 elements, unsorted)
    ArrayList<Integer> baseCaseRandomInput = new ArrayList<>();

    public Main(){
        populateInputArrays();
    }

    //helpers
    private void clearCounters(){
        if(rb != null){
            rb.setCounter(0);
        }
        if(st != null){
            st.setCounter(0);
        }
        if(tr != null){
            tr.setCounter(0);
        }
    }
    private void printRotationCounters(){
        System.out.println("    RedBlack: " + this.rb.getCounter());
        System.out.println("    SplayTree: " + this.st.getCounter());
        System.out.println("    Treap: " + this.tr.getCounter());
    }
    private void populateInputArrays(){
        for(int i=0; i<850; i++){
            baseCaseRandomInput.add(random.nextInt());
        }

        for(int i=0; i<12345; i++){
            Integer difference = random.nextInt(1000);
            if(random.nextBoolean()){
                unsortedExtremeValuesBigInput.add(min-difference);
            } else {
                unsortedExtremeValuesBigInput.add(max-difference);
            }
        }

        ArrayList<Integer> usedInSingles = new ArrayList<>();
        for(int i=0; i<12345; i++){
            Integer newInt = random.nextInt();
            if(!usedInSingles.contains(newInt)){
                usedInSingles.add(newInt);
                unsortedBigSingleValuesInput.add(newInt);
            }
        }

        ArrayList<Integer> usedInDoubles = new ArrayList<>();
        for(int i=0; i<12345; i++){
            Integer newInt = random.nextInt();
            if(!usedInDoubles.contains(newInt)){
                usedInDoubles.add(newInt);
                unsortedBigDoubleValuesInput.add(newInt);
            }
            if(random.nextBoolean()){
                unsortedBigDoubleValuesInput.add(usedInDoubles.get(i % usedInDoubles.size()));
                i++;
            }
        }
    }
    private void populateDataStructuresWithGivenInput(Integer[] inputArray){
        rb = new RedBlackTree<>();
        st = new SplayTree<>();
        tr = new Treap<>();

        for (Integer integer : inputArray) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
    }
    private void populateDataStructuresWithGivenInput(ArrayList<Integer> inputArray){
        rb = new RedBlackTree<>();
        st = new SplayTree<>();
        tr = new Treap<>();

        for (Integer integer : inputArray) {
            rb.insert(integer);
            st.insert(integer);
            tr.insert(integer);
        }
    }

    //Input insertion tests
    public void sortedSmallTest(){
        populateDataStructuresWithGivenInput(sortedSmallInput);
        System.out.println("Small sorted input - rotation count");
        printRotationCounters();
    }
    public void reverseSortedSmallTest(){
        populateDataStructuresWithGivenInput(reverseSortedSmallInput);
        System.out.println("Small reverse sorted input - rotation count");
        printRotationCounters();
    }
    public void unsortedSmallTest(){
        populateDataStructuresWithGivenInput(unsortedSmallInput);
        System.out.println("Small unsorted input - rotation count");
        printRotationCounters();
    }
    public void unsortedSmallWithDoublesTest(){
        populateDataStructuresWithGivenInput(unsortedWithDoubleValuesSmallInput);
        System.out.println("Small unsorted input with doubles - rotation count");
        printRotationCounters();
    }
    public void unsortedExtremeTest(){
        populateDataStructuresWithGivenInput(unsortedExtremeValuesBigInput);
        System.out.println("Unsorted extreme values input, big - rotation count");
        printRotationCounters();
    }

    public void unsortedBigSingleValuesTest(){
        populateDataStructuresWithGivenInput(unsortedBigSingleValuesInput);
        System.out.println("Unsorted single values input, big - rotation count");
        printRotationCounters();
    }
    public void unsortedBigDoubleValuesTest(){
        populateDataStructuresWithGivenInput(unsortedBigDoubleValuesInput);
        System.out.println("Unsorted double values input, big - rotation count");
        printRotationCounters();
    }

    public void baseCaseRandomTest(){
        populateDataStructuresWithGivenInput(baseCaseRandomInput);
        System.out.println("Base case with random input - rotation count");
        printRotationCounters();
    }

    //user pattern tests
    public void firstAddThenRemoveTest(){
        populateDataStructuresWithGivenInput(baseCaseRandomInput);
        clearCounters();
        //copy of input to keep track of current elements
        currentElements = new ArrayList<>(baseCaseRandomInput);
        do{
            int index = random.nextInt(currentElements.size());
//            rb.remove(currentElements.get(index));
            st.remove(currentElements.get(index));
            tr.remove(currentElements.get(index));
            currentElements.remove(index);
        }while(currentElements.size()>0);
        System.out.println("Remove all - rotation count - 850 elements");
        printRotationCounters();
    }

    public void mixedAddAndRemoveTest(){
        rb = new RedBlackTree<>();
        st = new SplayTree<>();
        tr = new Treap<>();
        currentElements = new ArrayList<>();
        Integer temp;

        for(int i=0; i<=850;){
            for(int j=0; j<6;j++){
                temp = random.nextInt();
                currentElements.add(temp);
//                rb.insert(temp);
                st.insert(temp);
                tr.insert(temp);
                i++;
            }
            for(int k=0; k<4; k++){
                temp = currentElements.get(random.nextInt(currentElements.size()-1));
                currentElements.remove(temp);
 //               rb.remove(temp);
                st.remove(temp);
                tr.remove(temp);
                i++;
            }
        }
        System.out.println("Alternating add and then remove, - rotation count - 850 method calls");
        printRotationCounters();
    }


    public static void main(String[] args){
        Main main = new Main();

        //different input rotation measurement tests
        main.sortedSmallTest();
        main.reverseSortedSmallTest();
        main.unsortedSmallTest();
        main.unsortedSmallWithDoublesTest();
        main.unsortedExtremeTest();
        main.unsortedBigSingleValuesTest();
        main.unsortedBigDoubleValuesTest();

        //base case input, used for pattern tests
        main.baseCaseRandomTest();

        //user pattern tests
        main.firstAddThenRemoveTest();
        main.mixedAddAndRemoveTest();


    }
}
