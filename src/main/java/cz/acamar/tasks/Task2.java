package cz.acamar.tasks;

import cz.acamar.tasks.exception.NotValidArrayException;

import java.util.Arrays;

public class Task2 {
    private int[] inputArr;

    /**
     * Task 2. Squares of a sorted array.
     * <p>
     * Given an integer array sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     * <p>
     * Example input: [-4,-1,0,3,10]
     * Expected output: [0,1,9,16,100]
     * <p>
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     * @param input - an integer array sorted in non-decreasing order
     * @return - an array of the squares of each number sorted in non-decreasing order
     */
    public int[] squaresOfSortedArray(int[] input) {
        inputArr = input;

        if (isNullPointerOrArrayEmpty()) {
            throw new NotValidArrayException("Getting null pointer or empty array!");
        }

        int[] outputArr = Arrays.copyOf(inputArr, inputArr.length); // Probably for really BIG array method System.arraycopy() can be faster.

        for (int i = 0; i < outputArr.length; i++) {
            outputArr[i] *= outputArr[i]; // Probably work faster than Math.pow().
        }

        Arrays.sort(outputArr);
        return outputArr;
    }

    private boolean isNullPointerOrArrayEmpty() {
        return inputArr == null || inputArr.length == 0;
    }
}
