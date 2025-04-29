public class Node {
    private final int value;
    private Node next;


    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public String toString() {
        if (this.next == null) {
            return String.format("Node(%s, null)", this.value);
        }
        else {
            return String.format("Node(%s, %s)", this.value, this.next);
        }
    }

    public int getValue() {
        return this.value;
    }

    public void setNode(Node next) {
        this.next = next;
    }

    public Node getNode() {
        return this.next;
    }

}
