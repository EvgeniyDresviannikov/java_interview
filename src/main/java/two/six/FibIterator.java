package two.six;

import two.two.FindUrl;

import java.util.Iterator;

public class FibIterator {
    public static void main(String[] strings) {
        FibonacciIterator iterator = new FibonacciIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class FibonacciIterator implements Iterator<Integer> {
    private Integer first = 0;
    private Integer second = 0;

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    @Override
    public boolean hasNext() {
        return getFirst()+getSecond() >= getSecond();
    }

    @Override
    public Integer next() {
        if (getFirst().equals(getSecond()) && getFirst().equals(0)) {
            setFirst(1);
            setSecond(0);
            return 0;
        }

        if (getFirst().equals(1) && getSecond().equals(0)) {
            setFirst(0);
            setSecond(1);
            return 1;
        }

        Integer var = getFirst();
        setFirst(second);
        setSecond(var+getSecond());
        return getSecond();
    }

}

class FibonacciIterable implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }
}