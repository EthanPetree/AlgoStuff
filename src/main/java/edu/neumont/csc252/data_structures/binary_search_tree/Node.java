package edu.neumont.csc252.data_structures.binary_search_tree;

import java.util.List;

public class Node <T extends Comparable <T>> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    protected Node(T data) {
        setData(data);
        setLeft(null);
        setRight(null);
    }



    protected T getData() {
        return data;
    }

    protected void setData(T data) {
        this.data = data;
    }

    protected Node<T> getLeft() {
        return left;
    }

    protected void setLeft(Node<T> left) {
        this.left = left;
    }

    protected Node<T> getRight() {
        return right;
    }

    protected void setRight(Node<T> right) {
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

    /**
     * Order: Left Root Right
     * O(n)
     * @return A formatted, in-order string representation of the array.
     */
    public String inOrder(){
        String leftInOrder = "";
        String rightInOrder = "";

        if (getLeft() != null){
            leftInOrder = getLeft().inOrder() + ", ";
        }

        if (getRight() != null){
            rightInOrder = ", " + getRight().inOrder();
        }

        // LEFT             ROOT          RIGHT
        return leftInOrder + getData() + rightInOrder;
    }

    /**
     * Formats a tree into a string and returns it
     * O(n)
     * @return a string format of the tree going root left right
     */
    public String preOrder(){
        String leftInOrder = "";
        String rightInOrder = "";

        if (getLeft() != null){
            leftInOrder =  ", " + getLeft().preOrder();
        }

        if (getRight() != null){
            rightInOrder = ", " + getRight().preOrder();
        }

        //       ROOT          LEFT         RIGHT
        return  getData() + leftInOrder + rightInOrder;
    }

    /**
     * Formats a tree into a string and returns it
     * O(n)
     * @return a string format of the tree going left right root
     */
    public String postOrder(){
        String leftInOrder = "";
        String rightInOrder = "";

        if (getLeft() != null){
            leftInOrder = getLeft().postOrder() + ", ";
        }

        if (getRight() != null){
            rightInOrder = getRight().postOrder() + ", ";
        }

        // LEFT             RIGHT          ROOT
        return leftInOrder + rightInOrder + getData();
    }

    /**
     * Gets the height of the node.
     * Children height + 1 for this instance.
     * O(n)
     * @return height based on the position of this node
     */
    public int height(){
        int leftHeight = 0;
        int rightHeight = 0;

        if (getLeft() != null){
            leftHeight = getLeft().height();
        }

        if(getRight() != null){
            rightHeight = getRight().height();
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }


    /**
     * Converts the current node into an array representation
     * O(n)
     * Order: Left Root Right
     * @param arr the array to populate
     */
    public int toArray(List<T> arr, int currentIndex){
        if (getLeft() != null){
            currentIndex = getLeft().toArray(arr, currentIndex);
        }

        // root - add ourselves
//        arr[currentIndex++] = getData();
        arr.add(getData());

        if (getRight() != null){
            currentIndex = getRight().toArray(arr, currentIndex);
        }

        return currentIndex;
    }

    /**
     * Returns true if the value matches the data of the node
     * O(n)
     * @param val the value to compare to
     * @return boolean true if found, false if not
     */
    /*
    Determine if the value would be to the left or right or if it is equal
    use a depth-first search to check each node
    call into the left until we either find the value or it hits the bottom return statement
    repeat for the right
    return true all the way up if the value is found
    false will return all the way up if it is not in the tree
     */
    public boolean contains(T val){
        if(val.compareTo(getData()) < 0){
            if(getLeft() != null){
               return getLeft().contains(val);
            }
        } else if (val.compareTo(getData()) > 0){
            if (getRight() != null){
                return getRight().contains(val);
            }
        } else {
            return true;
        }
        return false;
    }

    /**
     * Searches and remove a value from the tree
     * O(n)
     * @param val the value to search for
     * @return the biggest child node for the next pass when called recursively
     */
    public Node<T> remove(T val){
        if (val.compareTo(getData()) < 0){
            //left
            if(getLeft() != null){
                setLeft(getLeft().remove(val));
            }
        } else if (val.compareTo(getData()) > 0){
            //go right
            if(getRight() != null){
                setRight(getRight().remove(val));
            }
        } else {
            // found it

            // 0 or 1 child
            if(getLeft() == null){ // 0 or 1 max
                return getRight();
            } else if (getRight() == null){
                return getLeft();
            }

            // 2 children
            setData(MaxValue(getLeft()));
            setLeft(getLeft().remove(getData()));
        }

        return this;
    }

    private T MaxValue(Node<T> root){
        while(root.getRight() != null){
            root = root.getRight();
        }

        return root.getData();
    }

    private T MinValue(Node<T> root){
        while(root.getLeft() != null){
            root = root.getLeft();
        }

        return root.getData();
    }
}
