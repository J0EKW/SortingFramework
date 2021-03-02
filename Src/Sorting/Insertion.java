package Src.Sorting;

/**Insertion Sorting algorithm */
public class Insertion extends Sort{
    
    /**Main method where Insertion sort is executed
     * 
     * @param input A dataset
     * @param compare   boolean representing the metric the values in the dataset will be compared by (True = by length, False = by Value)
     * @return  Sorted Dataset
     */
    public static String[] algorithm(String[] input, boolean compare) {
        compare = getType(input, compare);
        int i = 1;
        int j = 0;

        while (i < input.length) {
            j = i;
            while (j > 0 && checkComp(input[j - 1], input[j], compare)) {
                swap(input, j - 1, j);
                j--;
            }
            i++;
        }
        return input;
    }

    /**Swaps the values at the two indecies with each other
     * 
     * @param input A dataset
     * @param iOne  An index
     * @param iTwo  An index
     * @return  The updated dataset
     */
    private static String[] swap(String[] input, int iOne, int iTwo) {
        String temp = input[iOne];
        input[iOne] = input[iTwo];
        input[iTwo] = temp;

        return input;

    }
}
