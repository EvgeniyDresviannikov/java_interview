package two.six;

public class TreeIteratorTest {
    public static void main(String[] strings) {
        NodeInt root = new NodeInt(20,
                                   new NodeInt(7,
                                               new NodeInt(4, null, new NodeInt(6)), new NodeInt(9)),
                                   new NodeInt(35,
                                              new NodeInt(31, new NodeInt(28), null),
                                              new NodeInt(40, new NodeInt(38), new NodeInt(52))));
        TreeIterator iterator = new TreeIterator(root);
        while (iterator.hasNext()) {
            Node nxt = iterator.next();
        }
    }
}
