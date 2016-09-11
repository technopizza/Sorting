/*******************************************************************************
* Filename: Sort.Java Author: Conklin, Jason Date: September 9, 2016
* 
* Description: This class contains different methods for sorting array
* 
* Input: None
* 
* Output: Console
*******************************************************************************/
package sortingalgorithms;

public class Sort {

     /********************************************************************************
    * Method: printArray
    * 
    * Description: prints out the array in an easily human-readable format
    * 
    * Parameters: int[] array
    * 
    * Pre-Conditions: array must have been initialized.
    * 
    * Post-Conditions: the values in the array will be printed to the console
    *******************************************************************************/
    public static void printArray(int[] array) {
        
        for (int i = 0; i < array.length; i++) { // iterates through each value in the array
            if (i == array.length - 1) {
                    System.out.println(array[i]);
                } else {
                    System.out.print(array[i] + ", "); //prints value at i with some formatting
                }
        }
        System.out.println();
    }

     /********************************************************************************
    * Method: swap
    * 
    * Description: swaps the values at different two indexes in an array
    * 
    * Parameters: int[] array, int index1, int index2
    * 
    * Pre-Conditions: array must have been initialized. array must have a length of at least 2
    * 
    * Post-Conditions: the values at array[index1] and array[index2] will be switched
    *******************************************************************************/
    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1]; //stores the value at index1 in a temporary variable
        array[index1] = array[index2]; //moves the value at index2 to index1
        array[index2] = tmp; //moves the original index1 value to index2

    }

     /********************************************************************************
    * Method: selectionSort
    * 
    * Description: Sorts an array of values by moving the smallest value in an
    *              ever-shrinking subset to the beginning of the subset
    * 
    * Parameters: int[] array
    * 
    * Pre-Conditions: array must have been initialized.
    * 
    * Post-Conditions: array will be sorted, with values ordered from smallest to largest.
    *******************************************************************************/
    public static void selectionSort(int[] array) {
        
        int steps = 0; //varaible to store the number of swaps required to sort the array
        int smallestValueIndex; //varaible to store the index of the current smallest value in the subset
        
        System.out.println("Selection Sort:");
        
        /* Outer loop controls the current index that defines the subset being searched.
        Also, the outer loop moves the smallest number in the subset found by the inner loop to the first position in the subset */
        for (int i = 0; i < array.length - 1; i++) { //gradually shrinks the subset
            
            smallestValueIndex = i; //defines the beginning of the subset
            System.out.println("    starting at index " + (i+1) + ", the starting smallest value is " + array[smallestValueIndex]);
            
            /* inner loop defines a subset and searches it for values smaller than the first item in the subset*/
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[smallestValueIndex]){//if a smaller value is found, records it
                    
                    System.out.println("        " + array[j] + ", at index " + j + ", is less than " + array[smallestValueIndex]);
                    System.out.println("        " + array[j] + " is the new smallest value");
                    
                    smallestValueIndex = j; //records the index with the new smallest vlue
                }
                else{
                    System.out.println("        " + array[j] + ", at index " + j + ", is greater than or equal to " + array[smallestValueIndex]);
                    System.out.println("        " + array[smallestValueIndex] + " remains the smallest value");
                }
            }
            if (array[smallestValueIndex] < array[i]) { //checks new smallest value against original, and if it is, in fact, smaller, swaps them
                
                System.out.println("    the new smallest value, " + array[smallestValueIndex] +
                        " is less than the original smallest value, " + array[i]);
                System.out.println("    swapping array[" + i + "] with array[" + smallestValueIndex + "]");
                
                swap(array, i, smallestValueIndex); //swaps the new smallest value with the first item in the subset
                steps++; //increment by one, since a swap has taken place
            }
            else{
                    System.out.println("    the new smallest value, " + array[smallestValueIndex] +
                        " is greater than or equal to the original smallest value, " + array[i]);
                    System.out.println("    no swapping required");
                }
        }

        printArray(array);
        System.out.println("It took " + steps + " steps to selection sort this array");
    }
    
    /********************************************************************************
    * Method: insertionSort
    * 
    * Description: Sorts an array of values by inserting each value at the appropriate index
    * 
    * Parameters: int[] array
    * 
    * Pre-Conditions: array must have been initialized.
    * 
    * Post-Conditions: array will be sorted, with values ordered from smallest to largest.
    *******************************************************************************/
    public static void insertionSort(int[] array) {
        
        int steps = 0; //varaible to store the number of swaps required to sort the array
        boolean move = false;
        System.out.println("Insertion Sort:");
        
        /* Outer loop controls the current index to insert. */
        for (int i = 1, a = i; i < array.length; i++, a++) { //int a is just a simple tracker of how many times the methods actually inserts a number
            
            /* inner loop compares the value at the current index
            with the value at each index below it, making swaps if necessary*/
            
            for (int j = i - 1; j >= 0; j--) { //starts at the index below i, checks every value down to index zero
                
                if(array[i] < array[j]){ //compares the value of the insert index with the value of the current index
                    System.out.println();
                    System.out.println("    " + array[i] + " at index " + i + " is less than " + array[j] + " at index " + j);
                    System.out.println("    swapping value at index " + i + " with the value at index " + j);
                    System.out.println();
                    swap(array, i, j); //moves the insert value down
                    
                    i = j; //decrements i to "follow" the insert value all the way down the chain
                    
                }
                else{
                    System.out.println("    array[" + i + "] is less than or equal to array[" + (j) + "]");
                    System.out.println("    no swapping required");
                }
            }
            if(i < a){ //i will be less than a if an insertion took place
                steps++; //increment by one, since an insertion has taken place
                a = i; //reset a to track the next insertion
            }
        }
        printArray(array);
        System.out.println("It took " + steps + " steps to insertion sort this array");
    }
    
    /********************************************************************************
    * Method: bubbleSort
    * 
    * Description: Sorts an array of values by comparing values and repeatedly
    *              swapping smaller values toward the "front" of the array.
    * 
    * Parameters: int[] array
    * 
    * Pre-Conditions: array must have been initialized.
    * 
    * Post-Conditions: array will be sorted, with values ordered from smallest to largest.
    *******************************************************************************/
    public static void bubbleSort(int[] array) {
       
        int steps = 0; //varaible to store the number of swaps required to sort the array
        
        System.out.println("Bubble Sort:");
        
        /* Outer loop controls the current highest index to sort through.
           The highest index decreases by one each iteration, to prevent
           resorting already sorted items */
        for (int i = array.length; i > 0; i--) {
            System.out.println("    iterating through array from index 0 to index " + (i - 1));
            
            /* inner loop compares each pair of values
            in the array and executes the appropriate swaps*/
            for (int j = 0; j < i - 1; j++) {
                System.out.println("        comparing array[" + j + "] and array[" + (j+1) + "]");
                
                if(array[j] > array[j + 1]){ //compares each pair of values, starting at zero and 1
                    System.out.println();
                    System.out.println("        array[" + j + "] is greater than array[" + (j+1) + "]");
                    System.out.println("        swapping the value at array[" + j + "] with the value at array[" + (j+1) + "]");
                    System.out.println();
                    swap(array, j, (j + 1)); //swaps the larger and smaller value
                    steps++; //increment by one, since a swap has taken place
                    
                    }
                else{
                    System.out.println("        array[" + j + "] is less than or equal to array[" + (j+1) + "]");
                    System.out.println("        no swapping required");
                }
            }
        }
        printArray(array);
        System.out.println("It took " + steps + " steps to bubble sort this array");
    }
}
