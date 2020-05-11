package two.four;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateClassCastException {
    public static  void main(String[] strings) {
        GenerateClassCastException generateClassCastException = new GenerateClassCastException();
        List<Integer> list = generateClassCastException.generateBadList();
    }
    List<Integer> generateBadList() {
        List res = Stream.iterate(0, i -> i < 11, i -> i + 1).collect(Collectors.toList());
        res.add("I'm Integer");
        return res;
    }


}
