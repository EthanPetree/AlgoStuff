package edu.neumont.csc252.data_structures.binary_search_tree;

public class Node <T extends Comparable <T>> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T data) {
        setData(data);
        setLeft(null);
        setRight(null);
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * Adds a value to this node's children.
     * Adds if child is null, passes on if not.
     * T: O(log n)
     * @param data
     */
    public void add(T data){
        if (data.compareTo(getData()) >= 0){
            if (getRight() == null){
                setRight(new Node<>(data));
            } else {
                getRight().add(data);
            }
        } else {
            if (getLeft() == null){
                setLeft(new Node<>(data));
            } else {
                getLeft().add(data);
            }
        }
    }
}
