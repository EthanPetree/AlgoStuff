package edu.neumont.csc252.data_structures.double_linked_list;

public class Node <T extends Comparable <T>> {
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(T data) {
        this(data, null, null);
    }

    public Node(T data, Node<T> next, Node<T> previous) {
        setData(data);
        setNext(next);
        setPrevious(previous);
    }

    public T getData() {
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        if (getData() == null){
            return "";
        }
        return getData().toString();
    }
}
