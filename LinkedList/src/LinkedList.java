public class LinkedList <E> {
    // inner protected node
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
           this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(int index, E e) {
        if(index < 0 || index > size) {
           throw new IllegalArgumentException("Add Failed. Illegal index.");
        }
        Node prev = dummyHead;
        for(int i = 0 ; i < index; i++) {
            prev = prev.next;
        }

        // key point find add node prev node
//            Node node  = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * Add element in linked list fist
     * @param e
     */
    public void addFirst(E e) {
        this.add(0, e);
    }

    /**
     * Add element in linked list last
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }
}

