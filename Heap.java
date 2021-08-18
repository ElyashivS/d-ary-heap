package com.company;

/**
 * This program represent a d-ary heap, according to page 119 in the book.
 * Authors: Melina Aides, and Elyashiv Shefa.
 */
public class Heap {
    // Instance variables
    private int[] _array;
    private int _size;
    private int _heapSize;
    private int _d;

    // Constructor - builds an array of 1000 cells to store the heap.
    public Heap(int d) {
        _array = new int[1000];
        _size = 999;
        _heapSize = 0;
        _d = d;
    }

    // Methods

    // This method increases the value of the received index i to the received key.
    public void increaseKey(int i, int key) {
        int max = Math.max(_array[i], key);
        _array[i] = max;

        while (i > 1 && _array[getParent(i)] < _array[i]) {
            exchange(i, getParent(i));
            i = getParent(i);
        }
    }

    // This method inserts the received key to it's right place in the heap.
    public void insert(int key) {
        if (key > 0 && _heapSize < _size) {
            _heapSize++;
            _array[_heapSize] = -1;
            increaseKey(_heapSize, key);
        }
    }

    // This method returns the index of the parent of a given index.
    private int getParent(int i) {
        return (int) Math.floor((double)((i - 2) / _d) + 1);
    }

    // This method returns the index of the son of a given index.
    public int getSon(int i, int k) {
        if(isEmpty())
            System.out.println("The heap is empty");
        int son = (_d * i) - _d + 1 + k;
        return son;
    }

    // This method extracts and returns the max value of the heap and rearranges the heap.
    public int extractMax() {
        if (isEmpty())
            System.out.println("Heap is empty.");

        int max = _array[1];
        _array[1] = _array[_heapSize];
        _array[_heapSize] = 0;
        _heapSize--;
        maxHeapify(1);
        return max;
    }

    // This method deletes a given index from the heap, and rearranges the heap.
    public void delete(int i) {
        if (i < _heapSize) {
            exchange(i, _heapSize);
            _array[_heapSize] = 0;
            _heapSize--;
            maxHeapify(i);
        }
        else System.out.println("Error: there is no index " + i + " in the heap");
    }

    // This method prints the heap.
    public String toString() {
        String s = "";
        for (int i = 1; i <= _heapSize; i++) {
            s += _array[i];
            if (i != _heapSize)
                s += ", ";
        }
        return s;
    }


    // Private methods
    // This method receives two indexes and exchanges the values between them.
    private void exchange(int i, int j) {
        int temp = _array[i];
        _array[i] = _array[j];
        _array[j] = temp;
    }

    // This method returns true if the heap is empty.
    private boolean isEmpty() {
        return _size == 0;
    }

    // This method fixes the heap to be a valid Max-heap.
    private void maxHeapify(int i) {
        int value = _array[i];
        int max = i;
        int index = i;
        for (int j = 1; j <= _d; j++) {
            if (getSon(i, j) <= _heapSize && _array[getSon(i, j)] > _array[i]) {
                if (_array[getSon(i, j)] > max) {
                    max = _array[getSon(i, j)];
                    index = getSon(i, j);
                }
            }
        }
        if (index != i) {
            exchange(i, index);
            maxHeapify(index);
        }
    }
}
