package org.example;

import java.util.Comparator;

/**
 * Class for sorting arrays.
 */
public class QuickSort {
    /**
     * Sorts the input array using a quick sort.
     *
     * @param arr input array.
     * @param from beginning of array sorting.
     * @param to end of array sorting.
     * @param comparator Comparator for sorting values in the array.
     */
    public void quickSort(Object[] arr, int from, int to,
                          Comparator<Object> comparator) {
        if (from < to) {
            int divideIndex = partition(arr, from, to, comparator);
            quickSort(arr, from, divideIndex - 1, comparator);
            quickSort(arr, divideIndex, to, comparator);
        }
    }

    private int partition(Object[] arr, int from, int to,
                          Comparator<Object> comparator) {
        int leftIndex = from, rightIndex = to, mid = from + (to - from) / 2;
        Object pivot = arr[mid];

        while (leftIndex <= rightIndex) {
            while (comparator.compare(arr[leftIndex], pivot) < 0) {
                leftIndex++;
            }
            while (comparator.compare(arr[rightIndex], pivot) > 0 ) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                Object temp = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
}
