package two.five;

public class BoxBox {
    public static void main(String[] strings) {
        BoxBox boxBox = new BoxBox();
        Box<Integer> box = boxBox.boxingValue(2.39);
        System.out.println(box.getValue());
    }

    Box<Integer> boxingValue(double value) {
        return new Box(value);
    }

}

class Box<T> {
    private final T value;

    Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}