package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @param <E>
 */
public class RealizationMyArrayList<E> implements MyList {
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private final QuickSort quickSort = new QuickSort();
    private Object[] arr;

    public RealizationMyArrayList(int capacity) {
        if (capacity > 0) {
            this.arr = new Object[capacity];
        } else throw new IllegalArgumentException("Capacity cannot be less than 1");
    }

    public RealizationMyArrayList() {
        this.arr = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object values) {
        if (size == arr.length) {
            resize(arr.length * 2);
        }
        arr[size++] = values;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(arr, 0, newArray, 0, size);
        arr = newArray;
    }

    @Override
    public void add(int indexToInsert, Object values) {
        if (size == arr.length) {
            resize(arr.length * 2);
        }
        int index = size;
        size++;
        for (int i = size; i > indexToInsert; i--) {
            Object temp = arr[index];
            arr[i] = temp;
            index--;
        }
        arr[indexToInsert] = values;
    }

    @Override
    public Object get(int index) {
        if (size > index) return arr[index];
        else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void delete(int index) {
        if (size > index) {
            for (int i = index; i < size; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void clear() {
        Object[] clearArray = arr;
        for (int i = size; i > 0; i--) {
            clearArray[i] = null;
            size--;
        }
    }

    @Override
    public void sort(Comparator c) {
        quickSort.quickSort(arr, 0, size - 1, c);
    }

    @Override
    public void replace(int index, Object values) {
        if (size > index) {
            arr[index] = values;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealizationMyArrayList<?> that = (RealizationMyArrayList<?>) o;
        return size == that.size && Objects.equals(quickSort, that.quickSort) && Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, quickSort);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, size));
    }
}
