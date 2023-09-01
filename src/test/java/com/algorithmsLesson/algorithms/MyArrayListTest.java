package com.algorithmsLesson.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList();
    }

    @Test
    void testAdd() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";

        assertEquals(item1, list.add(item1));
        assertEquals(item2, list.add(item2));
    }

    @Test
    void testAddAtIndex() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";
        String item3 = "пункт 3";

        list.add(item1);
        list.add(item3);
        list.add(1, item2);

        assertEquals(3, list.size());
        assertEquals(item1, list.get(0));
        assertEquals(item2, list.get(1));
        assertEquals(item3, list.get(2));
    }

    @Test
    void testSet() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";

        list.add(item1);
        assertEquals(item1, list.set(0, item2));
        assertEquals(item2, list.get(0));
    }

    @Test
    void testRemoveByItem() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";
        String item3 = "пункт 3";

        list.add(item1);
        list.add(item2);
        list.add(item3);

        assertEquals(item2, list.remove(item2));
        assertFalse(list.contains(item2));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveByIndex() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";
        String item3 = "пункт 3";

        list.add(item1);
        list.add(item2);
        list.add(item3);

        assertEquals(item2, list.remove(1));
        assertFalse(list.contains(item2));
        assertEquals(2, list.size());
    }

    @Test
    void testContains() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";

        list.add(item1);
        assertTrue(list.contains(item1));
        assertFalse(list.contains(item2));
    }

    @Test
    void testIndexOf() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";

        list.add(item1);
        list.add(item2);

        assertEquals(0, list.indexOf(item1));
        assertEquals(1, list.indexOf(item2));
    }

    @Test
    void testLastIndexOf() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";
        String item3 = "пункт 1";

        list.add(item1);
        list.add(item2);
        list.add(item3);

        assertEquals(2, list.lastIndexOf(item1));
        assertEquals(1, list.lastIndexOf(item2));
    }

    @Test
    void testGet() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";

        list.add(item1);
        list.add(item2);

        assertEquals(item1, list.get(0));
        assertEquals(item2, list.get(1));
    }

    @Test
    void testEquals() {
        StringList otherList = new MyArrayList();
        String item1 = "пункт 1";
        String item2 = "пункт 2";

        list.add(item1);
        list.add(item2);
        otherList.add(item1);
        otherList.add(item2);

        assertTrue(list.equals(otherList));

        otherList.remove(item1);
        assertFalse(list.equals(otherList));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());

        list.add("пункт 1");
        list.add("пункт 2");
        assertEquals(2, list.size());

        list.remove("пункт 1");
        assertEquals(1, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add("пункт 1");
        assertFalse(list.isEmpty());

        list.remove("пункт 1");
        assertTrue(list.isEmpty());
    }

    @Test
    void testClear() {
        list.add("пункт 1");
        list.add("пункт 2");

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testToArray() {
        String item1 = "пункт 1";
        String item2 = "пункт 2";

        list.add(item1);
        list.add(item2);

        String[] array = list.toArray();

        assertEquals(2, array.length);
        assertEquals(item1, array[0]);
        assertEquals(item2, array[1]);
    }
}
