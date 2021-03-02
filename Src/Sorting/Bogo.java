package Src.Sorting;

import java.util.Random;

/**Bogo sorting algorithm */
public class Bogo extends Sort {

        /**Main method where Bogo sort is executed
     * 
     * @param input A dataset
     * @param compare   boolean representing the metric the values in the dataset will be compared by (True = by length, False = by Value)
     * @return  Sorted Dataset
     */
    public static String[] algorithm(String[] input, boolean compare) {
        Random random = new Random();
        compare = getType(input, compare);
        int i = 0;
        int j = 0;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            i = random.nextInt(input.length);
            j = random.nextInt(input.length);
            swap(input, i, j);
            for (int k = 1; k < input.length; k++) {
                if (checkComp(input[k-1], input[k], compare)) {
                    sorted = false;
                }
            }
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
