package JavaAdvanced.P16IteratorsAndComparatorsExercises.P03StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Stack<T> implements Iterable<T> {
    private List<T> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public void push(T element) {
        elements.add(element);
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("No elements");
        }
        return elements.remove(elements.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int currentIndex;

        public StackIterator() {
            currentIndex = elements.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements.get(currentIndex--);
        }
    }
}