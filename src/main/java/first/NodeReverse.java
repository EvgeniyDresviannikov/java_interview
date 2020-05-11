package first;

public class NodeReverse {
    public static void main(String[] strings) {
        NodeReverse nodeReverse = new NodeReverse();
        Node node1 = new Node();
        node1.setData(1);

        Node node2 = new Node();
        node2.setData(2);

        Node node3 = new Node();
        node3.setData(3);

        node1.setNext(node2);
        node2.setNext(node3);

        Node res = nodeReverse.reverse(node1);
    }

    private void readNode(Node node) {
         while (node != null) {
            node = node.getNext();
        }
    }

    Node reverse(Node head) {
        Node curr = head;
        Node a = null;
        Node reverseHead = null;
        int length = 0;

        if (head == null) {return null;}

        while (curr != null) {
            length++;
            curr = curr.getNext();
        }

        for (int i = length-1; i >= 0; i--) {
            a = head;
            for (int j = 0; j < i; j++) {
                a = a.getNext();
            }
            if (i == length-1) {
                reverseHead = a;
                curr = reverseHead;
                continue;
            }
            Node node = a;
            a.setNext(null);
            curr.setNext(node);

            curr = curr.getNext();
        }

        return reverseHead;
    }


}

