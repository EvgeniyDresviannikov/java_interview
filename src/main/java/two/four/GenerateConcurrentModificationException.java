package two.four;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GenerateConcurrentModificationException {
    public static  void main(String[] strings) {
        GenerateConcurrentModificationException generateConcurrentModificationException = new GenerateConcurrentModificationException();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        generateConcurrentModificationException.genConcurrentModificationException(list);
    }

    void genConcurrentModificationException(List<Integer> integers) {
        for (Integer integer : integers) {
            integers.add(4);
        }
    }
}
