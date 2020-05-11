package two.six;

import java.util.Iterator;
import java.util.Stack;

class TreeIterator implements Iterator<Node> {
    private final Node root;
    private Stack<Node> stack;

    public TreeIterator(Node root) {
        this.root = root;
        this.stack = new Stack<>();
        this.stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
        Node current = stack.pop();
        if (current.getLeft() != null) {
            stack.push(current.getLeft());
        }

        if (current.getRight() != null) {
            stack.push(current.getRight());
        }

        return current;
    }
}

interface Node{
    Node getLeft();
    Node getRight();
}

class NodeInt implements Node {
    private Integer value;
    private NodeInt left;
    private NodeInt right;

    public NodeInt(Integer value, NodeInt left, NodeInt right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public NodeInt(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public Node getLeft() {
        return this.left;
    }

    @Override
    public Node getRight() {
        return this.right;
    }
}