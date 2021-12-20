package Stack_Src;

import java.util.EmptyStackException;

public class Stack {
    private Node lastNode;
    private Node firstNode;
    private int count = 0;

    public Stack() {
        var node = new Node();
        node.setNext(null);
        lastNode = firstNode = node;
        count++;
    }

    public int size() {
        return count;
    }

    public void push(String value) {
        Node node = new Node(value);
        lastNode.setNext(node);
        lastNode = node;
        count++;
    }

    public String pop() throws EmptyStackException {
        if (count >= 1) {
            String value = lastNode.getValue();
            var node = new Node();
            node = firstNode;
            while (node.getNext() != lastNode)
                node = node.getNext();

            node.setNext(null);
            lastNode = node;
            count--;
            return value;

        } else {
            throw new EmptyStackException();
        }
    }

    public String peek() {
        return lastNode.getValue();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contains(String value) {
        var node = new Node();
        node = firstNode;
        if (node.getValue().equalsIgnoreCase(value))
            return true;
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getValue().equalsIgnoreCase(value))
                return true;
        }
        return false;
    }



    @Override
    public String toString() {
        String str = new String("");
        var node = new Node();
        node = firstNode;

        while (node.getNext() != null){
            str += node.getValue();
            str += " ";
            node = node.getNext();
        }

        return str;
    }
}
