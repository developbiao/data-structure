public class LinkedList<E> {
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
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Add element by index
     * @param index
     * @param e
     */
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

    /**
     * Get element by index
     * @param index
     * @return
     */
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i ++) {
           cur = cur.next;
        }
        return cur.e;
    }

    /**
     * get first element
     * @return
     */
    public E getFirst() {
        return get(0);
    }


    /**
     * Get last element
     * @return
     */
    public E getLast() {
        return get(size - 1) ;
    }

    /**
     * Modify linked list index(0-based) position element e
     * @param index
     */
    public void set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Set Failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i ++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    /**
     * Judge contains element in linked list
     * @param e
     * @return
     */
    public boolean contains(E e) {
       Node cur = dummyHead.next;
       while(cur != null) {
           if(cur.e.equals(e)){
              return true;
           }
          cur = cur.next;
       }
       return false;
    }

    /**
     * Remove Element by index
     * @param index
     * @return
     */
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i ++) {
           prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    /**
     * remove fist element
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * remove last element
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.e.equals(e)) {
                // found
               break;
            }
            prev = prev.next;
        }

        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }

    }




    public String toString() {
        StringBuilder res = new StringBuilder();

        for(Node cur = dummyHead.next; cur != null; cur = cur.next) {
           res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}

