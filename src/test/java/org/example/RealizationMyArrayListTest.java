package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RealizationMyArrayListTest {
    private static final RealizationMyArrayList<Integer> arr = new RealizationMyArrayList<>();

    @BeforeEach
    void setUp() {
        arr.add(2);
        arr.add(1);
        arr.add(4);
        arr.add(3);
    }

    @Test
    void testSize() {
        assertEquals(4, arr.size());
    }

    @Test
    void testAdd() {
        arr.add(5);
        assertEquals(5, arr.get(4));
        assertEquals(5, arr.size());
    }

    @Test
    void testAddIndex() {
        arr.add(1, 5);
        assertEquals(5, arr.get(1));
        assertEquals(1, arr.get(2));
        assertEquals(4, arr.get(3));
        assertEquals(5, arr.size());
    }

    @Test()
    void testAddIndexNotFound() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arr.add(17, 5));
    }
    @Test()
    void testAddNegativeIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arr.add(-1, 5));
    }

    @Test
    void testGet() {
        assertEquals(4, arr.get(2));
    }
    @Test
    void testGetNotFoundIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arr.get(10));
    }

    @Test
    void testGetNegativeIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arr.get(-1));
    }

    @Test
    void testDelete() {
        arr.delete(2);
        assertEquals(3, arr.size());
    }

    @Test
    void testDeleteNotFoundIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arr.delete(10));
    }

    @Test
    void testDeleteNegativeIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arr.delete(-1));
    }

    @Test
    void testClear() {
        arr.clear();
        assertEquals(0, arr.size());
    }

    @Test
    void testSort() {
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        assertEquals(1, arr.get(0));
        assertEquals(2, arr.get(1));
        assertEquals(3, arr.get(2));
        assertEquals(4, arr.get(3));
    }

    @Test
    void testReplace() {
        arr.replace(2, 10);
        assertEquals(10, arr.get(2));
    }

    @Test
    void testReplaceNotFoundIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arr.replace(10, 10));
    }

    @Test
    void testReplaceNegativeIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arr.replace(-1, 10));
    }

    @AfterEach
    void teardown() {
        arr.clear();
    }
}