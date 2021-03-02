package Src.Sorting;

import java.util.Arrays;

/**Merge Sorting algorithm */
public class Merge extends Sort{
    
    /**Main method where Merge sort is executed
     * 
     * @param input A dataset
     * @param compare   boolean representing the metric the values in the dataset will be compared by (True = by length, False = by Value)
     * @return  Sorted Dataset
     */
    public static String[] algorithm(String[] input, boolean compare) {
        compare = getType(input, compare);
        split(input, 0, input.length, compare);
        return input;
    }

    /**Recursively breaks the dataset down into the smallest possible sections before merging them back together
     * 
     * @param input A dataset
     * @param begin The start index of the subset
     * @param end   The end index of the subset
     * @param compare   boolean representing the metric the values in the dataset will be compared by (True = by length, False = by Value)
     */
    private static void split(String[] input, int begin, int end, boolean compare) {
        
        if (end - begin <= 1) { return; }
        int middle = (begin + end) / 2;

        split(input, begin, middle, compare);
        split(input, middle, end, compare);

        merge(input, begin, middle, end, compare);
    }

    /**Method that combines two ordered sub sets to make an ordered superset
     * 
     * @param input A dataset
     * @param begin The starting index of the first subset
     * @param middle    The ending index of the first subset as well as the starting index of the second subset
     * @param end   The ending index of the second subset
     * @param compare   boolean representing the metric the values in the dataset will be compared by (True = by length, False = by Value)
     */
    private static void merge(String[] input, int begin, int middle, int end, boolean compare) {
        String[] A = Arrays.copyOfRange(input, begin, middle);
        String[] B = Arrays.copyOfRange(input, middle, end);

        int i = 0;
        int j = 0;

        for (int k = begin; k < end; k++) {
            if (i < A.length && (j >= B.length || checkComp(B[j], A[i], compare))) {
                input[k] = A[i];
                i++;
            }
            else {
                input[k] = B[j];
                j++;
            }
        }
    }

}
