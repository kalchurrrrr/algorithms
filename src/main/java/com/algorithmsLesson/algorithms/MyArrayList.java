package com.algorithmsLesson.algorithms;

import java.util.Arrays;

public class MyArrayList implements StringList {
    private static final int DEFAULT_CAPACITY = 10;
    private String[] array;
    private int size;

    public MyArrayList() {
        array = new String[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть больше 0");
        }
        array = new String[capacity];
        size = 0;
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Не удается добавить null в список");
        }
        if (size >= array.length) {
            expandArray();
        }
        array[size++] = item;
        return item;
    }

    @Override
    public void add(int index, String item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс выходит за рамки");
        }
        if (item == null) {
            throw new IllegalArgumentException("Не удается добавить null в список");
        }
        if (size >= array.length) {
            expandArray();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за рамки");
        }
        if (item == null) {
            throw new IllegalArgumentException("Не удается установить значение null для списка");
        }
        String replacedElement = array[index];
        array[index] = item;
        return replacedElement;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Не удается установить значение null в список");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return remove(i);
            }
        }
        throw new IllegalArgumentException("Элемент, не найденный в списке");
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за рамки");
        }
        String removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removedElement;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Не удается выполнить поиск по null в списке");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Не удается выполнить поиск по null в списке");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Не удается выполнить поиск по null в списке");
        }
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за рамки");
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Другой список не может быть пустым");
        }
        if (otherList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new String[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void expandArray() {
        int newCapacity = array.length * 2;
        String[] newArray = new String[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
