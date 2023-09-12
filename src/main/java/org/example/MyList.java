package org.example;

import java.util.Comparator;

public interface MyList<E> {
    int size();
    void add(E e);
    void add(int index, E e);
    E get(int index);
    void delete(int index);
    void clear();
    void sort(Comparator<? super E> c);
    void replace(int index, E e);
}
