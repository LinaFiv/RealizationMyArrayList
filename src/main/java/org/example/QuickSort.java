package org.example;

import java.util.Comparator;

/**
 *
 */
public class QuickSort {
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
