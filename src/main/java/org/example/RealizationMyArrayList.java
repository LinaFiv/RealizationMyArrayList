package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Resizable-array implementation of the {@link MyList} interface.
 *
 * @param <E> the type of elements in this array.
 */
public class RealizationMyArrayList<E> implements MyList {
    private int size;

    private int capacity;
    private static final int DEFAULT_CAPACITY = 16;
    private final QuickSort quickSort = new QuickSort();
    private Object[] arr;

    public RealizationMyArrayList(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            this.arr = new Object[capacity];
        } else throw new IllegalArgumentException("Capacity cannot be less than 1");
    }

    public RealizationMyArrayList() {
        capacity = DEFAULT_CAPACITY;
        this.arr = new Object[capacity];
    }

    /**
     * Returns the size of the array.
     *
     * @return size of the array.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds a new value to the end of the array.
     *
     * @param value new value to add.
     */
    @Override
    public void add(Object value) {
        if (size + 1 >= capacity) {
            increaseCapacity();
        }
        arr[size++] = value;
    }

    /**
     * Adds a new value by index of the array.
     *
     * @param indexToInsert index where the value to be inserted.
     * @param value         new value to add.
     * @throws ArrayIndexOutOfBoundsException if the index is outside the bounds of the array.
     */
    @Override
    public void add(int indexToInsert, Object value) {
        if (indexToInsert > size) throw new ArrayIndexOutOfBoundsException();
        if (size + 1 >= capacity) {
            increaseCapacity();
        }
        size++;
        for (int i = size - 1; i > indexToInsert; i--) {
            arr[i] = arr[i - 1];
        }
        arr[indexToInsert] = value;
    }

    /**
     * Changes the capacity of the array when it is filled.
     */
    private void increaseCapacity() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(arr, 0, newArray, 0, size);
        arr = newArray;
    }

    /**
     * Returns a value from the array by index.
     *
     * @param index index of the value to be received.
     * @return value from the array by index.
     * @throws ArrayIndexOutOfBoundsException if the index is outside the bounds of the array.
     */
    @Override
    public Object get(int index) {
        if (size > index) return arr[index];
        else throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Removes a value from the array by index.
     *
     * @param index index of the value to be deleted.
     * @throws ArrayIndexOutOfBoundsException if the index is outside the bounds of the array.
     */
    @Override
    public void delete(int index) {
        if (size > index) {
            for (int i = index; i < size; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Clears the array.
     */
    @Override
    public void clear() {
        Object[] clearArray = arr;
        for (int i = size; i > 0; i--) {
            clearArray[i] = null;
            size--;
        }
    }

    /**
     * Sorts the array using {@link QuickSort}.
     *
     * @param comparator Comparator for sorting values in the array.
     */
    @Override
    public void sort(Comparator comparator) {
        quickSort.quickSort(arr, 0, size - 1, comparator);
    }

    /**
     * Replaces a value from the array by index.
     *
     * @param index index of the value to be replaced.
     * @param value new value to insert.
     * @throws ArrayIndexOutOfBoundsException if the index is outside the bounds of the array.
     */
    @Override
    public void replace(int index, Object value) {
        if (size > index) {
            arr[index] = value;
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
