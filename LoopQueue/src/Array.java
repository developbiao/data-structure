public class Array<E> {
    private E[] data;
    private int size;

    /**
     *
     * construct
     * @param capacity
     */
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;

    }

    public Array() {
        this(10);
    }

    /**
     *  get size
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     *  get capacity
     * @return
     */
    public int getCapacity() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addLast(E e) {
        this.add(this.size, e);
    }

    public void addFirst(E e) {
        this.add(0, e);
    }


    public void add(int index, E e) {
        if(this.size == this.data.length) {
            throw new IllegalArgumentException("AddLast failed. Array is full.") ;
        }

        if(index < 0 || index > size)
        {
           throw new IllegalArgumentException("Add failed. Required index >=0 and <= size.");
        }

        for(int i = this.size - 1; i >= index; i--)
        {
            this.data[i + 1] = this.data[i];
        }

        this.data[index] =  e;
        size ++;
    }

    /**
     *
     * Get element by index
     * @param index
     * @return
     */
    public E get(int index) {
        if( index < 0 || index > this.size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return this.data[index];
    }

    public E getLast()
    {
       return data[size - 1];
    }

    public E getFirst()
    {
       return data[0];
    }

    /**
     * Set value with index
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if(index < 0 || index > this.size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        this.data[index] = e;
    }


    /**
     * Query element contains in the array
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for(int i = 0; i < data.length; i++) {
           if(data[i] == e) {
               return true;
           }
        }
        return false;
    }

    /**
     * find element index when not found return -1
     * @param e
     * @return
     */
    public int find(E e) {
        for(int i = 0; i < data.length; i++) {
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Remove element by index
     * @param index
     * @return
     */
    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed, Index is illegal.");
        }

        E ret = data[index];
        for(int i = index + 1; i < size; i++) {
           data[i - 1]  =  data[i];
        }
        size --;
        return ret;
    }

    /**
     * remove first element
     * @return
     */
    public E removeFirst() {
       return remove(0);
    }

    /**
     *
     * remove last element
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }


    /**
     * remove element with array
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if(index  != -1) {
            remove(index);
        }

    }



    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append(String.format("Array: size = %d, capacity = %d\n",this.size , this.getCapacity() ) );
       res.append('[');
       for (int i=0; i < this.size; i++) {
           res.append(data[i]);
           if(i != this.size - 1)
           {
               res.append(", ");
           }
       }
       res.append(']');
       return res.toString();
    }

    private void resize(int newCapacity)
    {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i< size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


}
