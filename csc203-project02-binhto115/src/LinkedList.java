public class LinkedList {
    private Node firstNode;

    /**
     * Constructor for LinkedList
     * Create a linked list with no node (AKA first node = null)
    */
    public LinkedList() {
        firstNode = null;
    }

    public Node getFirstNode() {
        return this.firstNode;
    }

    // This method gets the next node in a list based on the given index
    public Node getNode(int index) {
        Node currentNode = firstNode;
        for (int i = 0; i < index; i ++) {
            currentNode = currentNode.getNode();
        }
        return currentNode;
    }

    /**
     * This function returns a new list after the given value is
     added to a Node indicated by the given index. Raise IndexError
     if the index is greater than the length of the list or less than zero.
     * */
/*    public void add(int value, int index) {
        Node node = new Node(value);
        if (index == 0) {
            node.setNode(firstNode);
            firstNode = node;
        }
        else if (index > 0 & firstNode == null) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        else if (index < 0) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        else {
            Node addNextNode = getNode(index - 1);
            node.setNode(addNextNode.getNode());
            addNextNode.setNode(node);
        }
    }*/

    /**
     * This method is purposely used for calculation*/
    public void addToFront(int value) {
        Node node = new Node(value);
        node.setNode(firstNode);
        firstNode = node;
    }


    /**
     * This function returns a tuple of the removed element and a new list
     * indicated by the index. If the list is empty or the index is out of range,
     * the function will raise an IndexError.
     */
    public String remove(int index) {
        int removedNode;
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is out of range!");
        }
        else if (index == 0) {
            removedNode = firstNode.getValue();
            firstNode = firstNode.getNode();
        }
        else {
            Node node = getNode(index - 1);
            Node newRest = node.getNode();
            removedNode = newRest.getValue();
            node.setNode(newRest.getNode());

            }
        return Integer.toString(removedNode);
    }

    public String reversedToString(String str) {
        LinkedList reversedList = new LinkedList();

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            reversedList.addToFront(Integer.parseInt(Character.toString(character)));
        }
        Node currentNode = reversedList.getFirstNode();
        while (currentNode != null) {
            result += Integer.toString(currentNode.getValue());
            currentNode = currentNode.getNode();
        }
        return result;
    }

    public LinkedList reversedToList(String str) {
        LinkedList reversedList = new LinkedList();
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            reversedList.addToFront(Integer.parseInt(Character.toString(character)));
        }
        return reversedList;
    }

    public int size(String string) {
        return string.length();
    }
}


