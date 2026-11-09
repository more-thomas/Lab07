public class LinkedList<T> {

    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    private Node first;
    private Node last;

    public LinkedList() {
        first = null;
        last = null;
    }

    // Add a value to the beginning of the list
    public void addFirst(T value) {
        Node node = new Node(value);
        node.next = first;
        first = node;

        if (last == null) {
            last = node;
        }
    }

    // Add a value to the end of the list
    public void addLast(T value) {
        Node node = new Node(value);

        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }

        last = node;
    }

    //checks if the vals are equal
    public boolean equals(LinkedList<T> other) {
        if (other == null) {
            return false;
        }

        Node current = first;
        Node otherCurrent = other.first;

        while (current != null && otherCurrent != null) {
            if (current.value == null) {
                if (otherCurrent.value != null) {
                    return false;
                }
            } else if (!current.value.equals(otherCurrent.value)) {
                return false;
            }

            current = current.next;
            otherCurrent = otherCurrent.next;
        }

        return current == null && otherCurrent == null;
    }
}
