package org.example;

import java.util.Comparator;

/**
 * An ordered list. The user of this interface has precise control over where in the list each element is inserted.
 * The user can access elements by their integer index, and search for elements in the list,
 * and can replace the element by index.
 * The user can sort the list and can clear the list.
 *
 * @param <E> the type of elements in this list.
 */
public interface MyList<E> {

    /**
     * Returns size of the list.
     *
     * @return size of the list
     */
    int size();

    /**
     * Adds a new element to the end of the list.
     *
     * @param e new element to add.
     */
    void add(E e);

    /**
     * Adds a new element by index of the list.
     *
     * @param index index where the element to be inserted.
     * @param e     new element to add.
     */
    void add(int index, E e);

    /**
     * Returns the element from the list by index.
     *
     * @param index index of the element to be received.
     * @return element from the list by index.
     */
    E get(int index);

    /**
     * Removes the element from the list by index.
     *
     * @param index index of the element to be deleted.
     */
    void delete(int index);

    /**
     * Clears the list.
     */
    void clear();

    /**
     * Sorts the list.
     *
     * @param c Comparator for sorting elements in the list.
     */
    void sort(Comparator<? super E> c);

    /**
     * Replaces the element from the list by index.
     *
     * @param index index of the element to be replaced.
     * @param e     new element to insert.
     */
    void replace(int index, E e);
}
