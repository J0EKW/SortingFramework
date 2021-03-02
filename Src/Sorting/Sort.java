package Src.Sorting;

/**Class That all sorting algorithms must inherit from */
public abstract class Sort {
    
    /**Main Method in which algorithm is executed
     * 
     * @param input A dataset
     * @param compare   A boolean value represent by what metric the values in the data set are compared by
     * @return  A sorted dataset
     */
    protected static String[] algorithm(String[] input, boolean compare) { return input; }

    /**Compares two strings by their length
     * 
     * @param valOne
     * @param valTwo
     * @return  If the first value is longer than the second
     */
    protected static boolean byLen(String valOne, String valTwo) { return valOne.length() > valTwo.length(); }

    /**Compares two numbers by their value
     * 
     * @param valOne
     * @param valTwo
     * @return  If the first value is larger than the second
     */
    protected static boolean byVal(Double valOne, Double valTwo) { return valOne > valTwo; }

    /**Gets the type of data that's being processed
     * 
     * @param input A dataset to be sorted
     * @param compare   The metric by which values in the data set will be compared
     * @return  The validated comparison boolean
     */
    protected static boolean getType(String[] input, boolean compare) {
        try {
            for (String i : input) {
                Double.parseDouble(i);
            }
        } catch (NumberFormatException e) {
            
            if (!compare) {
                compare = true;
                System.out.println("Your compare variable is incorrect, it has been updated");
            }
        }
        return compare;
        
    }

    /**Compares two values by the given boolean compare
     * 
     * @param a
     * @param b
     * @param compare
     * @return  If the first value is longer/larger than the second
     */
    protected static boolean checkComp(String a, String b, boolean compare) {
        return compare ? byLen(a, b) : byVal(Double.parseDouble(a), Double.parseDouble(b));
    }
}
