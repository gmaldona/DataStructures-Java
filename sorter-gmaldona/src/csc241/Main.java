package csc241;

import java.util.Random;

class Main {

    static void main(String[] args) {

		int [] inputArray = new int[10];
        
		Random r = new Random();
		// initialize with random numbers
		for (int i = 0; i < inputArray.length; i++) {
		  // Generate random int bounded by array size
		  inputArray[i] = r.nextInt(inputArray.length);
		}
			// Show Array
		System.out.println("---=== Before ===---");
		System.out.println(arrayToString(inputArray));
		System.out.println();

		// Create a Sorter object
		Sorter sorter = new Sorter();
		int count = 0; // Count the shift/swap operations
		count = sorter.insertionSort(inputArray);
		//count = sorter.quickSort(inputArray, 0, inputArray.length - 1);

		// Show sorted array
		System.out.println("---=== Sorted ===---");
		System.out.println(arrayToString(inputArray));
		System.out.println("Count: " + count);
			
    }

    // Return a string representation of an int array
    static String arrayToString(int[] a) {
        String str = "";
        for (int i = 0; i < a.length; i++) {
            // Append element string
            str += "[" + a[i] + "]";
        }
        return str;
    }  

	
}

