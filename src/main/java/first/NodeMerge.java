package first;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class NodeMerge {
    public static void main(String[] strings) {
        NodeMerge nodeMerge = new NodeMerge();
        Node node1 = new Node();
        node1.setData(8);

        Node node2 = new Node();
        node2.setData(11);

        Node node3 = new Node();
        node3.setData(12);

        node1.setNext(node2);
        node2.setNext(node3);

        Node node4 = new Node();
        node4.setData(1);

        Node node5 = new Node();
        node5.setData(2);

        Node node6 = new Node();
        node6.setData(5);

        node4.setNext(node5);
        node5.setNext(node6);

        Node res = nodeMerge.merge(node1, node4);
    }


    Node merge(Node head1, Node head2) {
        Node newHead = new Node();
        Node a = new Node();

        a = newHead;

        while (head1 != null || head2 != null) {
            if ( (head1 != null && head2 != null && head1.getData() <= head2.getData()) || head2 == null) {
                a.setNext(head1);
                a = a.getNext();
                head1 = head1.getNext();
            } else {
                a.setNext(head2);
                a = a.getNext();
                head2 = head2.getNext();
            }
        }

        Node curr = newHead;
        while (curr != null) {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }

        return newHead;
    }

    private Node addNextNode(Node currNode, int nextValue) {
        if (currNode.getData() == 0) {
            currNode.setData(nextValue);
            return currNode;
        } else {
            Node nextNode = new Node();
            nextNode.setData(nextValue);
            currNode.setNext(nextNode);
            return currNode.getNext();
        }
    }
}



class Node  {
    private int data;
    private Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}