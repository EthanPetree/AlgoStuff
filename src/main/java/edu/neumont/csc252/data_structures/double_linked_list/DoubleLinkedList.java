package edu.neumont.csc252.data_structures.double_linked_list;

public class DoubleLinkedList<T extends Comparable <T>> {
    private Node<T> head;
    private Node<T> tail;
    private int count = 0;


    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = count;
    }

    /*
    Big O(n)
     */
    public void add(T data){
        if (getHead() == null){
            setHead(new Node<>(data));
            setTail(getHead());
        } else {
            Node<T> lastNode = getTail();
            lastNode.setNext(new Node<>(data));
            lastNode.getNext().setPrevious(lastNode);
            setTail(lastNode.getNext());
        }

        setCount(getCount() + 1);
    }

    public T get(int index){
        Node<T> foundNode = findNode(index);
        return foundNode.getData();
    }

    /**
     * Finds the node at the given index
     * Big-O T: O(n) S: O(1)
     * @param index to search for
     * @return the node if found
     * @throws IndexOutOfBoundsException if out of index
     */
    private Node<T> findNode(int index){
        if (index < 0 || index >= getCount()){
            throw new IndexOutOfBoundsException();
        }

        if (getHead() == null || getTail() == null){
            throw new IllegalStateException();
        }

        int currentIndex;
        Node<T> currentNode;
        if (index < getCount() / 2) {
            currentNode = getHead();
            currentIndex = 0;
            while (currentIndex < index) {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
        } else {
            currentIndex = getCount() - 1;
            currentNode = getTail();
            while (currentIndex > index) {
                currentNode = currentNode.getPrevious();
                currentIndex--;
            }
        }

        return currentNode;
    }

    /**
     * Finds and removes the first item in the collection
     * T: O(1) S: O(1)
     * @return value of item removed
     */
    public T remove(){
        if (getHead() == null){
            throw new IllegalStateException();
        }

        T headData = getHead().getData();
        setHead(getHead().getNext());
        if(getHead() != null){
            getHead().setPrevious(null);
        } else {
            setTail(null);
        }

        //decrement
        setCount(getCount() - 1);

        return headData;
    }

    public T removeAt(int index){
        if (index < 0 || index >= getCount()){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            return remove();
        }
        if(index == getCount() - 1){
            return removeLast();
        }

//        Node<T> previousNode = findNode(index - 1);
//        T nodeData = previousNode.getNext().getData();
//        previousNode.setNext(previousNode.getNext().getNext());
        Node<T> nodeToRemove = findNode(index);
        T nodeData = nodeToRemove.getData();
        nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
        nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());

        setCount(getCount() - 1);

        return nodeData;
    }

    public T removeLast(){
        if (getCount() == 0){
            throw new IllegalStateException();
        }
        if (getCount() == 1){
            return remove();
        }
        Node<T> tailNode = getTail();
        T returnVal = tailNode.getData();
        setTail(tailNode.getPrevious());
        tailNode.getPrevious().setNext(null);

        setCount(getCount() - 1);

        return returnVal;
    }

    /**
     *inserts a value at the given index
     * @param val the value to be inserted
     * @param index the position where the value will be inserted
     */
    public void insertAt(T val, int index){
        if (index == 0){
            if(getCount() == 0){
                add(val);
                return;
            }
            Node<T> firstNode = new Node<>(val, getHead(), null);
            getHead().setPrevious(firstNode);
            setHead(firstNode);
        } else {

        // iterate to index - 1
        //a
        Node<T> previousIndex = findNode(index - 1);

        // new node b
        Node<T> newNode = new Node<>(val);
        // b.next = a.next
        newNode.setNext(previousIndex.getNext());
        newNode.setPrevious(previousIndex);
        // a.next = b
        previousIndex.setNext(newNode);
        newNode.getNext().setPrevious(newNode);
        }

        //increment
        setCount(getCount() + 1);
    }

    public void clear(){
        setHead(null);
        setTail(null);
        setCount(0);
    }

    /**
     * finds the index of the first match found of the value
     * @param val the value to search
     * @return the first index that the search value is at, -1 if not found
     */
    public int search(T val){ // is there a point to starting at the tail? it's not guaranteed to be sorted, so I think its fine
        if(getHead() == null){
            return -1;
        }

        Node<T> currentNode = getHead();
        int currentIndex = 0;
        while (currentNode != null){ //OR currentIndex == count
            if (currentNode.getData().compareTo(val) == 0){
               return currentIndex;
            }
            currentIndex++;
            currentNode = currentNode.getNext();
        }

        return -1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (getHead() == null){
            return "";
        }
        Node<T> currentNode = getHead();
        while (currentNode != null){
            sb.append(currentNode.getData());
            if (currentNode.getNext() != null){
                sb.append(", ");
            }
            currentNode = currentNode.getNext();
        }

        return sb.toString();
    }


}
