package JavaAdvanced.P16IteratorsAndComparatorsExercises.P01ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator<String> {
    private List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.elements = new ArrayList<>(Arrays.asList(elements));
        this.currentIndex = 0;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }



    public void print() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(elements.get(currentIndex));
    }

    @Override
    public boolean hasNext() {
        return currentIndex + 1 < elements.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            currentIndex++;
            return elements.get(currentIndex);
        }
        throw new IllegalStateException("Invalid Operation!");
    }
}