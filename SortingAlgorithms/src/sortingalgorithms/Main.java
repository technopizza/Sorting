/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

/**
 *
 * @author jconklin2391
 */
import java.util.*;



 
  public class Main {


     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randNum = new Random();
        final int arrLength = 20;
        boolean looping = true;
        int inputNum;
        String answer;
        int[] array = new int[arrLength];
        boolean found;
        int foundNum = 2000000000;

        do {
            for (int i = 0; i < array.length; i++) {
                array[i] = randNum.nextInt(100) + 1;
            }

            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    System.out.println(array[i]);
                } else {
                    System.out.print(array[i] + ", ");
                }
            }

            /* Create a menu that allows you to choose which sort(bubble, 
             selection, or insertion) is used to sort the numbers */
            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    System.out.println(array[i]);
                } else {
                    System.out.print(array[i] + ", ");
                }
            }
            
            Sort.bubbleSort(array);
            //Sort.selectionSort(array);
            //Sort.insertionSort(array);

            System.out.print("Please enter the number you wish to look for: ");
            System.out.println("");

            found = false;
            inputNum = input.nextInt();

            System.out.println("Linear Search algorithm:");
            System.out.println("");

            
            /*********************************************************************************************
            * Search Algorithm: Linear                                                                   *
            *                                                                                            *
            * Description: Iterates through an array in order, checking each index for a specified value *
            *                                                                                            *
            * Parameters: Array array, int inputNumber                                                   *
            *                                                                                            *
            * Pre-Conditions: none                                                                       *
            *                                                                                            *
            * Post-Conditions: if inputNum is located, found is set to true                              *
            *                  and foundNum is set equal to inputNum's index                             *
            *                                                                                            *
            **********************************************************************************************/
            /* Linear Search Algorithm */
            for (int i = 0; i < array.length; i++) { //iterates through entire array in order
                System.out.println("array[" + i + "] = " + array[i]); //prints the current index and its value
                /* check to see if desired number has been located */
                if (array[i] == inputNum) {
                    foundNum = i; //set foundNum to the index at which desired number was found
                    found = true;
                    break; //end the search
                }
                
                /* This code for use only with a sorted array.
                   Ends the search once the input value has been exceded by values in the array. */
                else if(array[i] > inputNum){
                    break; //end the search
                }
            }
            
            if (found) {
                System.out.println("The number " + inputNum
                        + " can be found at " + foundNum);
            } else {
                System.out.println("Sorry, " + " could not be found.");
            }

            System.out.println("Binary Search algorithm:");
            System.out.println("");

            found = false;

            /*********************************************************************************************
            * Search Algorithm: Binary / Tree                                                            *
            *                                                                                            *
            * Description: Iterates through an array by continuously halving the selection based on      *
            *              the range of values it contains, until a single index is reached              *
            * Parameters: Array array, int inputNumber                                                   *
            *                                                                                            *
            * Pre-Conditions: none                                                                       *
            *                                                                                            *
            * Post-Conditions: if inputNum is located, found is set to true                              *
            *                  and foundNum is set equal to inputNum's index                             *
            *                                                                                            *
            **********************************************************************************************/
            /* Binary Search Algorithm */
            int upperBound = array.length; //sets the upper bound for each iteration
            int lowerBound = 0; //sets the lower bound for each iteration
            
            /* stores the "middle" between the upper and lower bounds.
               always decides the new bounds for the next iteration */
            int currentIndex;
            
            while (!found) { //loop that keeps iterating until the number is found a single incorrect index is reached 
                currentIndex = (int) ((upperBound + lowerBound) / 2); //gets the "middle" of the bounds by averaging and rounding
                
                /* This allows exit from the loop when the binary search is complete */
                if (currentIndex == upperBound || currentIndex == lowerBound) { //checks to see if the bounds are closest
                    break;
                } else {
                    System.out.println("Looking between indeces " + lowerBound + " and " + upperBound);

                    System.out.println("The value at array[" + currentIndex + "] is " + array[currentIndex]);
                    /* check to see if desired number has been located */
                    if (array[currentIndex] == inputNum) {
                        foundNum = currentIndex; //set foundNum to the index at which desired number was found
                        found = true;
                    } 
                    /* gets the "upper half" of the current selection of the array by bringing the lower bound
                       up to where the "halway point" was before */
                    else if (array[currentIndex] < inputNum) {
                        System.out.println("Your number, " + inputNum + ", is greater than "
                                + array[currentIndex] + ", the value at array[" + currentIndex + "]");
                        lowerBound = currentIndex; //takes the upper half of the selection
                    }
                    /* gets the "lower half" of the current selection of the array by bringing the upper bound
                       down to where the "halway point" was before */
                    else if (array[currentIndex] > inputNum) {
                        System.out.println("Your number, " + inputNum + ", is less than "
                                + array[currentIndex] + ", the value at array[" + currentIndex + "]");
                        upperBound = currentIndex; //takes the lower half of the selection
                    }
                }

            }
            
            
            if (found) {
                System.out.println("The number " + inputNum
                        + " can be found at " + foundNum);
            } else {
                System.out.println("Sorry, " + " could not be found.");
            }

            System.out.println("Would you like to continue?");
            Scanner replay = new Scanner(System.in);
            answer = replay.next();

            System.out.println("");

            if (answer.equals("no")) {
                looping = false;
            }
        } while (looping);
    }

}
