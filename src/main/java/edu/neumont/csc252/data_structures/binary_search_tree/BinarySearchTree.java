package edu.neumont.csc252.data_structures.binary_search_tree;

public class BinarySearchTree <T extends Comparable <T>> {
    private Node<T> root;
    private int count = 0;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * adds a value to the binary search tree
     * T: O(n) S: O(n)
     * @param data the value to be added to the true
     */
    public void add(T data){
        if (getRoot() == null){
            setRoot(new Node<>(data));
        } else {
            getRoot().add(data);
        }

        setCount(getCount() + 1);
    }

    /**
     * Clears the binary search tree
     * O(1)
     */
    public void clear(){
        setRoot(null);
        setCount(0);
    }


}
