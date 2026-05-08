package edu.neumont.csc252.data_structures.single_linked_list;

public class Node <T extends Comparable <T>> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this(data, null); // fix
    }

    public Node(T data, Node<T> next) {
        setData(data);
        setNext(next);
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

    @Override
    public String toString() {
        if (getData() == null){
            return "";
        }
        return getData().toString();
    }
}
