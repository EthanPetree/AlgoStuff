package edu.neumont.csc250.sorting;

public class SortingLibrary<T extends Comparable <T>>  {

    /**
     *for (value)
     *  for(value)
     *      Compare index to index + 1
     *      if(index > index + 1) then swap
     *      if index < index + 1 then continue
     *
     *      Big O OC: O(n^2)
     *      Space SC: O(1)
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr){
        if (arr == null){
            throw new NullPointerException("The Array cannot be null");
        }

        for (int i = 0; i < arr.length; i++) { // O(n)
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) { // O(n)
                if(arr[j].compareTo(arr[j+1]) > 0){
                    swapped = true;
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    /**
     * for (value)
     *  for (value)
     *      Find the minimum value and index starting from first for value
     *      if index > minimum then swap
     *      if index < minimum then continue
     *
     * TC O(n^2) nested for loops that go to n
     * SC O(1)
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arr)
    {

        for (int i = 0; i < arr.length; i++) { // O(n)
//            T min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // O(n)
                if(arr[j].compareTo(arr[minIndex]) < 0){ //arr[minIndex] is the min value
//                    min = arr[j];
                    minIndex = j;
                }
            }

                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
        }
    }

    /**
     *start from index and decrement
     * if previous index is greater, it gets copied to index one and the previous value is stored
     * if copied, we store the index value
     * if the previous index is smaller, update the insertion point
     *
     * if we got to the start of the array the insertion point is 0
     * otherwise the insertion point is the point where j is
     *
     * at the end of each pass insert the held value at the insertion point
     *
     * TC: O(n^2) nested for loops that go n times
     * SC: O(1)
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arr)
    {
        for (int i = 1; i < arr.length; i++) {
            T valueHeld = arr[i];
            int insertionPoint = 0;
            for (int j = i; j > 0; j--) {
                if (valueHeld.compareTo(arr[j-1]) < 0) {
//                    valueHeld = arr[j];
                    arr[j] = arr[j - 1];
                }

                if(valueHeld.compareTo(arr[j-1]) >= 0){
                    insertionPoint = j;
                    break;
                }
            }

            arr[insertionPoint] = valueHeld; //always inserts
        }


    }

    /*
    The array must be sorted
    if null: error or return -1
    if empty or not found: -1

    Looking a search value
    find the midpoint (split)

    [1,2,3,4,5,6,7,8,9,10]
    SV - 3

    [1,2,3,4,5] [6,7,8,9,10]
    stop case : search size is 1 (didn't find it)
    didnt find it : return -1
    found the target : return the index
    go left - if the number larger than the search value
    -- call again but with the left side binarySearch(T[] left)
    go right - if the number is smaller than the search value
    -- call again but with the right side (T[] right)


    [1,2,3,4,5]
    [1,2,3] [4,5]


     */
    public static <T extends Comparable<T>> int binarySearch(int[] arr, int number, int start, int end){
        if (arr == null || arr.length == 0){
            return -1;
        }


        if(start == end){
            if (arr[start] == number){
                return start;
            } else {
                return -1;
            }
        }

        int middleIndex = (start + end) / 2; //((end - start) / 2) + start

        if(arr[middleIndex] == number){
            //found it
            return middleIndex;

        } else if (arr[middleIndex] > number){ //go left 0 - middle
            return binarySearch(arr, number, start, middleIndex - 1);
        } else { //go right middle - length  | if (arr[middleIndex] < number)
            return binarySearch(arr, number, middleIndex + 1, end);
        }

    }

    /*
    Merge Sort(O[])
    handle null empty etc
    if (O[] = 1) return
    half = length / 2;
    left[4] / right[4]
    copy O[] to L[]/R[]

    MergeSort(L[])
    MergeSort(R[])

    merge(L/R into O[])

     */
    public static <T extends Comparable<T>> void mergeSort(T[] o){
        if(o.length <= 1) {
            return;
        }
        int half = o.length / 2;

        T[] left = (T[])new Comparable[half];
        T[] right;
        if(o.length % 2 != 0){
            right = (T[])new Comparable[half + 1];
        } else {
            right = (T[])new Comparable[half];
        }

        //copy
        for (int i = 0; i < left.length; i++) {
            left[i] = o[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = o[i + (left.length)];
        }

        mergeSort(left);
        mergeSort(right);

        merge(o, left, right);
    }

    public static <T extends Comparable<T>> void merge(T[] o, T[] left, T[] right){
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < left.length && rightIndex < right.length){
            //comparion
            if (left[leftIndex].compareTo(right[rightIndex]) > 0){
                o[index] = right[rightIndex];
                rightIndex++;
            } else {
                o[index] = left[leftIndex];
                leftIndex++;
            }
            //leftIndex++ / rightIndex++
            index++;
        }

        //which still has room?
        if(leftIndex < left.length){
            //left room
            for (int i = leftIndex; i < left.length; i++) {
                o[index++] = left[i];
            }
        } else {
            //right has more to go
            for(int i = rightIndex; i < right.length; i++){
                //copy
                o[index++] = right[i];
            }
        }


    }

    /*
    QuickSort(T[] a, int start, int end)
    if start == end return;
    int pivotI = Partition(a, start, end);

    QuickSort(a, start, pivotI - 1);
    QuickSort(a, pivotI + 1, end);

    int Partition(T[] a, start, end)
    find pivot from start
    store pivot
    create L and R pointers
    if L >= pivot stop : increment L
    if R <= pivot stop : decrement R

    swap L and R

    if L == R return L || R
     */
    public static <T extends Comparable<T>> void quickSort(T[] o, int start, int end){
        if (start >= end){
            return;
        }
        int pivotI = partition(o, start, end);

        quickSort(o, start, pivotI - 1);
        quickSort(o, pivotI + 1, end);

    }

    public static <T extends Comparable<T>> int partition(T[] o, int start, int end){

        T pivot = o[start];
        int pointerL = start;
        int pointerR = end;

        while (pointerL != pointerR) {
            while (o[pointerL].compareTo(pivot) < 0) {
                pointerL++;
            }
            while (o[pointerR].compareTo(pivot) > 0) {
                pointerR--;
            }

            if (pointerL != pointerR && o[pointerL].compareTo( pivot) == 0 && o[pointerR].compareTo(pivot) == 0){
                pointerL++;
                continue;
            }

            T temp = o[pointerL];
            o[pointerL] = o[pointerR];
            o[pointerR] = temp;
        }

        return pointerL;
    }

    /*
    row by row
    recursively move to the next row
    not safe, iterate until it is safe
    next row, iterate if not found, backtrack to the previous and continue on

solution [0,2],[1,0],[2,3],[3,1]
    OR [2],[0],[3],[1] -- indexes are implied

    --
    row == n ? save solution/return;
    place queen
    validate position
    safe -> Recurse (next row)
    not safe || return from recursion -> iterate
    if no more room -> return;


     */
}
