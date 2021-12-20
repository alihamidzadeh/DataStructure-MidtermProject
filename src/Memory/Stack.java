package Memory;

import java.util.EmptyStackException;

public class Stack {
    private Memory.Node lastNode;
    private Memory.Node firstNode;
    private int count = 0;

    public Stack() {
        var node = new Memory.Node();
        node.setNext(null);
        lastNode = firstNode = node;
    }

    public int size() {
        return count;
    }

    public void push(String value) {
        if (count == 0) {
            firstNode.setValue(value);
            count++;
        } else {
            Memory.Node node = new Memory.Node(value);
            lastNode.setNext(node);
            lastNode = node;
            count++;
        }
    }

    public String pop() throws EmptyStackException {
        if (count > 1) {
            String value = lastNode.getValue();
            var node = new Memory.Node();
            node = firstNode;
            while (node.getNext() != lastNode)
                node = node.getNext();

            node.setNext(null);
            lastNode = node;
            count--;
            return value;

        } else if (count == 1) {
            String value = firstNode.getValue();
            firstNode.setNext(null);
            firstNode.setValue(null);
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
        var node = new Memory.Node();
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
        if (count != 0) {
            var node = new Memory.Node();
            node = firstNode;

            while (node.getNext() != null) {
                str += node.getValue();
                str += " ";
                node = node.getNext();
            }
            str += node.getValue();
        }
        return str;
    }
}
