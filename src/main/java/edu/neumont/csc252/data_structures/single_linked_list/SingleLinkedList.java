package edu.neumont.csc252.data_structures.single_linked_list;

public class SingleLinkedList  <T extends Comparable <T>> {
    private Node<T> head;
    private int count = 0;


    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
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
        } else {
            Node<T> lastNode = findNode(getCount() - 1);
            lastNode.setNext(new Node(data));
        }

        setCount(getCount() + 1);
    }

    public T get(int index){ // can I make a get that is private to return the actual node itself?
        Node<T> foundNode = findNode(index);
        return foundNode.getData();
    }

//    private Node<T> getNode(int index){ // can I make a get that is private to return the actual node itself?
//        if(getHead() == null || index < 0 || index >= getCount()){
//            throw new IndexOutOfBoundsException();
//        }
//
//        int currentIndex = 0;
//        Node<T> currentNode = getHead();
//        while(currentIndex < index){
//            currentNode = currentNode.getNext();
//            currentIndex++;
//        }
//
//        return currentNode;
//    }


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

        if (getHead() == null){
            throw new IllegalStateException();
        }

        int currentIndex = 0;
        Node<T> currentNode = getHead();
        while(currentIndex < index){
            currentNode = currentNode.getNext();
            currentIndex++;
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

        Node<T> previousNode = findNode(index - 1);
        T nodeData = previousNode.getNext().getData();
        previousNode.setNext(previousNode.getNext().getNext());
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
        Node<T> penultimateNode = findNode(getCount() - 2);
        T returnVal = penultimateNode.getNext().getData();
        penultimateNode.setNext(null);
        setCount(getCount() - 1);

        return returnVal;
    }

    /**
     *
     * @param val
     * @param index
     */
    public void insertAt(T val, int index){
        if (index == 0){
            Node<T> firstNode = new Node<>(val, getHead());
            setHead(firstNode);
        } else {

        // iterate to index - 1
        //a
        Node<T> previousIndex = findNode(index - 1);

        // new node b
        Node<T> newNode = new Node<>(val);
        // b.next = a.next
        newNode.setNext(previousIndex.getNext());
        // a.next = b
        previousIndex.setNext(newNode);
        }

        //increment
        setCount(getCount() + 1);
    }

    public void clear(){
        setHead(null);
        setCount(0);
    }

    /**
     * finds the index of the first match found of the value
     * @param val the value to search
     * @return the first index that the search value is at, -1 if not found
     */
    public int search(T val){
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
