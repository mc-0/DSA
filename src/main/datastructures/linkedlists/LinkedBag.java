package main.datastructures.linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<Item> implements Iterable<Item> {
    private Node first;    // beginning of bag
    private int n;         // number of elements in bag

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty bag.
     */
    public LinkedBag() {
        first = null;
        n = 0;
    }

    /**
     * Is this bag empty?
     *
     * @return true if this bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this bag.
     *
     * @param item the item to add to this bag
     */
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
     * Returns an iterator that iterates over the items in the bag.
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    // an iterator over a linked list
    private class LinkedIterator implements Iterator<Item> {
        private Node current;

        // creates a new iterator
        public LinkedIterator() {
            current = first;
        }

        // is there a next item in the iterator?
        public boolean hasNext() {
            return current != null;
        }

        // returns the next item in the iterator (and advances the iterator)
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
