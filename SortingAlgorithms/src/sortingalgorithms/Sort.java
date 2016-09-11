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

/**
 *
 * @author jconklin2391
 */
public class Sort {

    public static void printArray(int[] array) {
        System.out.print("  ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;

    }

    /********************************************************************************
    * Method: arrayInit Description: Sorts an array of values by finding the
    *         smallest values and putting them at index 0
    * 
    * Parameters: int[] array
    * 
    * Pre-Conditions: array[] must have been initialized.
    * 
    * Post-Conditions: array will be sorted, with values ordered from smallest to largest.
    *******************************************************************************/
    public static void selectionSort(int[] array) {
        
        int smallestValueIndex;

        for (int i = 0; i < array.length - 1; i++) {
            smallestValueIndex = i;
            System.out.println("ITERATION " + (i+1));
            System.out.println("    starting at index "+ (i+1) + ", smallest value is " + array[smallestValueIndex]);
            
            for (int j = i + 1; j < array.length; j++) {
                
                System.out.println("    index[" + j + "] = " + array[j]);
                
                if (array[j] < array[smallestValueIndex]) {
                    
                    System.out.println("        " + array[j] + " is less than " + array[smallestValueIndex]);
                    
                    smallestValueIndex = j;
                    
                    System.out.println("        " + array[j] + " is the new smallest value");
                }
            }
            if (array[smallestValueIndex] < array[i]) {
                
                swap(array, i, smallestValueIndex);
                
                System.out.println("    swapping array[" + i + "] with array[" + smallestValueIndex + "]");
            }
            
        }
        printArray(array);
        
    }
    /********************************************************************************
    * Method: arrayInit Description: Sorts an array of values by finding the
    *         smallest values and putting them at index 0
    * 
    * Parameters: int[] array
    * 
    * Pre-Conditions: array[] must have been initialized.
    * 
    * Post-Conditions: array will be sorted, with values ordered from smallest to largest.
    *******************************************************************************/
    public static void insertionSort(int[] array) {
        
        for (int i = 1; i < array.length; i++) {
            
            System.out.println("ITERATION " + i);
            System.out.println("    starting at index " + i);
            System.out.println("    current value is " + array[i]);
            for (int j = i - 1; j >= 0; j--) {
                
                if(array[i] < array[j]){
                    System.out.println(array[i] + " is less than " + array[j] + ", at index " + j);
                    swap(array, i, j);
                    System.out.println("swapping " + i + " with " + j);
                    i = j;
                    
                }
            }
                        
        }
        printArray(array);
        
    }
    /********************************************************************************
    * Method: arrayInit Description: Sorts an array of values by finding the
    *         smallest values and putting them at index 0
    * 
    * Parameters: int[] array
    * 
    * Pre-Conditions: array[] must have been initialized.
    * 
    * Post-Conditions: array will be sorted, with values ordered from smallest to largest.
    *******************************************************************************/
    public static void bubbleSort(int[] array) {
        
        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if(array[j] > array[j + 1]){
                    swap(array, j, (j + 1));
                }
            }
        }
        printArray(array);
        
       
        
    }
}
