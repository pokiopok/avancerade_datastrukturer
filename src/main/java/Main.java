import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    ArrayList<Integer> almostSortedMinusPLus50BigInput = new ArrayList<>();
    ArrayList<Integer> almostSortedRandomMiddlesBigInput = new ArrayList<>();
    ArrayList<Integer> unsortedBigSingleValuesInput = new ArrayList<>();
    ArrayList<Integer> unsortedExtremeValuesBigInput = new ArrayList<>();
    ArrayList<Integer> unsortedBigDoubleValuesInput = new ArrayList<>();

        //Base case input array (1000 elements, unsorted)
    ArrayList<Integer> baseCaseRandomInput = new ArrayList<>();

    public Main(){
        populateInputArrays();
    }

    //helpers
    private void clearCounters(){
        if(rb != null){
            rb.setCounter(0);
            rb.setSearchCounter(0);
        }
        if(st != null){
            st.setCounter(0);
            st.setSearchCounter(0);
        }
        if(tr != null){
            tr.setCounter(0);
            tr.setSearchCounter(0);
        }
    }
    private void printRotationCounters(){
        System.out.println("    RedBlack: " + this.rb.getCounter());
        System.out.println("    SplayTree: " + this.st.getCounter());
        System.out.println("    Treap: " + this.tr.getCounter());
    }
    private void printSearchCounters() {
        System.out.println("    RedBlack search: " + this.rb.getSearchCounter());
        System.out.println("    SplayTree search: " + this.st.getSearchCounter());
        System.out.println("    Treap search: " + this.tr.getSearchCounter());
    }

    private void populateInputArrays(){
        for(int i=0; i<1000; i++){
            baseCaseRandomInput.add(random.nextInt());
        }

        for(int i=-2; i<12345-2; i++){
            sortedBigInput.add(i);
        }

        for(int i=12345-3; i>-3; i--){
            reverseSortedBigInput.add(i);
        }

        for(int i=0; i<12345; i++){
            Integer difference = random.nextInt(1000);
            if(random.nextBoolean()){
                unsortedExtremeValuesBigInput.add(min-difference);
            } else {
                unsortedExtremeValuesBigInput.add(max-difference);
            }
        }

        for(int i=0; i<12345; i++){
            Integer difference = random.nextInt(100);
            almostSortedMinusPLus50BigInput.add(i+difference);
        }
        for(int i=0; i<12345; i++){
            if(i%20 == 0){
                almostSortedRandomMiddlesBigInput.add(random.nextInt());
            } else {
                almostSortedRandomMiddlesBigInput.add(i);
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
    public void unsortedExtremeValuesTest(){
        populateDataStructuresWithGivenInput(unsortedExtremeValuesBigInput);
        System.out.println("Unsorted extreme values input, big - rotation count");
        printRotationCounters();
    }
    public void sortedBigTest(){
        populateDataStructuresWithGivenInput(sortedBigInput);
        System.out.println("Sorted values input, big - rotation count");
        printRotationCounters();
    }
    public void reverseSortedBigTest(){
        populateDataStructuresWithGivenInput(reverseSortedBigInput);
        System.out.println("Reverse sorted values input, big - rotation count");
        printRotationCounters();
    }
    public void almostSortedRandomMiddlesBigTest(){
        populateDataStructuresWithGivenInput(almostSortedRandomMiddlesBigInput);
        System.out.println("Almost sorted random middle values input, big - rotation count");
        printRotationCounters();
    }
    public void almostSortedMinusPLus50BigTest(){
        populateDataStructuresWithGivenInput(almostSortedMinusPLus50BigInput);
        System.out.println("Almost sorted +-50 values input, big - rotation count");
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
    public void removeAllRandomOrderTest(){
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
        System.out.println("Remove all unsorted- rotation count - 1000 elements");
        printRotationCounters();
    }
    public void removeAllinOrderTest(){
        populateDataStructuresWithGivenInput(baseCaseRandomInput);
        clearCounters();
        //copy of input to keep track of current elements
        currentElements = new ArrayList<>(baseCaseRandomInput);
        //sort in order to remove in order
        Collections.sort(currentElements);
        for(Integer i : currentElements){
//            rb.remove(i);
            st.remove(i);
            tr.remove(i);
        }
        System.out.println("Remove all sorted- rotation count - 1000 elements");
        printRotationCounters();
    }

    public void removeAllRandomOrderSortedInputTest(){
        //copy and trim of input to keep track of current elements
        List<Integer> currentElementsList = sortedBigInput.subList(0,1000);
        currentElements = new ArrayList<>(currentElementsList);
        populateDataStructuresWithGivenInput(currentElements);
        clearCounters();
        do{
            int index = random.nextInt(currentElements.size());
//            rb.remove(currentElements.get(index));
            st.remove(currentElements.get(index));
            tr.remove(currentElements.get(index));
            currentElements.remove(index);
        }while(currentElements.size()>0);
        System.out.println("Remove all unsorted order - sorted input - rotation count - 1000 elements");
        printRotationCounters();
    }
    public void removeAllinOrderUnsortedInputTest(){
        //copy of input to keep track of current elements
        List<Integer> currentElementsList = unsortedBigSingleValuesInput.subList(0,1000);
        currentElements = new ArrayList<>(currentElementsList);
        populateDataStructuresWithGivenInput(currentElements);
        clearCounters();
        //sort in order to remove in order
        Collections.sort(currentElements);
        for(Integer i : currentElements){
//            rb.remove(i);
            st.remove(i);
            tr.remove(i);
        }
        System.out.println("Remove all sorted order - unsorted input - rotation count - 1000 elements");
        printRotationCounters();
    }
    public void removeAllInOrderSortedInputTest(){
        //copy and trim of input to keep track of current elements
        List<Integer> currentElementsList = sortedBigInput.subList(0,1000);
        currentElements = new ArrayList<>(currentElementsList);
        populateDataStructuresWithGivenInput(currentElements);
        clearCounters();
        Collections.sort(currentElements);
        for(Integer i : currentElements){
//            rb.remove(i);
            st.remove(i);
            tr.remove(i);
        }
        System.out.println("Remove all sorted order - sorted input - rotation count - 1000 elements");
        printRotationCounters();
    }
    public void removeAllRandomOrderUnsortedInputTest(){
        //copy and trip of input to keep track of current elements
        List<Integer> currentElementsList = unsortedBigSingleValuesInput.subList(0,1000);
        currentElements = new ArrayList<>(currentElementsList);
        populateDataStructuresWithGivenInput(currentElements);
        clearCounters();
        do{
            int index = random.nextInt(currentElements.size());
//            rb.remove(currentElements.get(index));
            st.remove(currentElements.get(index));
            tr.remove(currentElements.get(index));
            currentElements.remove(index);
        }while(currentElements.size()>0);
        System.out.println("Remove all random order - unsorted input - rotation count - 1000 elements");
        printRotationCounters();
    }

    public void mixedAddAndRemoveTest(){
        rb = new RedBlackTree<>();
        st = new SplayTree<>();
        tr = new Treap<>();
        currentElements = new ArrayList<>();
        Integer temp;

        for(int i=0; i<=1000;){
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
        System.out.println("Alternating add and then remove, - rotation count - 1000 method calls");
        printRotationCounters();
    }
    //Testar contains för random data
    public void containsRandomTest() {
        populateDataStructuresWithGivenInput(baseCaseRandomInput);
        clearCounters();
        for(int i = 0; i < 1000; i++) {
            Integer index = random.nextInt(0, baseCaseRandomInput.size() - 1);

            rb.contains(baseCaseRandomInput.get(index));
            st.contains(baseCaseRandomInput.get(index));
            tr.contains(baseCaseRandomInput.get(index));
        }
        System.out.println("Testing contains method for random searches - rotation count 1000 calls");
        printRotationCounters();
        printSearchCounters();
    }
    //behöver vi lägga till en searchdepth för att visa på styrkorna/svagheterna?
    //osäker på hur denna kan se ut
    public void simulatedMixedUsageTest() {
        currentElements = new ArrayList<>(baseCaseRandomInput);
        populateDataStructuresWithGivenInput(currentElements);
        clearCounters();

        //leta efter min, max, contains, samt insertions
        for(int i = 0; i < 1000; i++) {
            if(i % 12 == 0) {
                rb.findMax();
                st.findMax();
                tr.findMax();
            }
            if(i % 12 == 6) {
                rb.findMin();
                st.findMin();
                tr.findMin();
            }
            if(i % 12 == 3 || i % 12 == 9) {
                Integer newInt = random.nextInt();
                rb.insert(newInt);
                st.insert(newInt);
                tr.insert(newInt);
            }

            Integer index = random.nextInt(0,currentElements.size() - 1);
            rb.contains(currentElements.get(index));
            st.contains(currentElements.get(index));
            tr.contains(currentElements.get(index));
        }
        System.out.println("Testing simulated searches and insertions - rotation count 1000 calls");
        printRotationCounters();
        printSearchCounters();

    }


    public static void main(String[] args){
        Main main = new Main();

        //different input rotation measurement tests
        //small input
        main.sortedSmallTest();
        main.reverseSortedSmallTest();
        main.unsortedSmallTest();
        main.unsortedSmallWithDoublesTest();
        //big input
        main.sortedBigTest();
        main.reverseSortedBigTest();
        main.almostSortedRandomMiddlesBigTest();
        main.almostSortedMinusPLus50BigTest();
        main.unsortedBigSingleValuesTest();
        main.unsortedBigDoubleValuesTest();
        main.unsortedExtremeValuesTest();

        //base case input, used for pattern tests
        main.baseCaseRandomTest();

        //remove tests
        main.removeAllRandomOrderTest();
        main.removeAllinOrderTest();
        main.removeAllRandomOrderSortedInputTest();
        main.removeAllinOrderUnsortedInputTest();
        main.removeAllInOrderSortedInputTest();
        main.removeAllRandomOrderUnsortedInputTest();

        main.mixedAddAndRemoveTest();
        main.containsRandomTest(); //contains, random
        main.simulatedMixedUsageTest(); //findMin, findMax, contains, insert, random


    }
}
