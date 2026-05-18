package edu.neumont.csc252.data_structures.binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree <T extends Comparable <T>> {
    private Node<T> root;
    private int count = 0;

    private Node<T> getRoot() {
        return root;
    }

    private void setRoot(Node<T> root) {
        this.root = root;
    }

    public int getCount() {
        return count;
    }

    private void setCount(int count) {
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

    /**
     * Formats a tree into a string and returns it
     * O(n)
     * @return a string format of the tree going left root right
     */
    public String inOrder(){
        if (getRoot() == null){
            return "";
        }
        return getRoot().inOrder();
    }

    /**
     * Formats a tree into a string and returns it
     * O(n)
     * @return a string format of the tree going root left right
     */
    public String preOrder(){
        if (getRoot() == null){
            return "";
        }
        return getRoot().preOrder();
    }

    /**
     * Formats a tree into a string and returns it
     * O(n)
     * @return a string format of the tree going left right root
     */
    public String postOrder(){
        if (getRoot() == null){
            return "";
        }
        return getRoot().postOrder();
    }

    /**
     * Gets the hieght of the tree.
     * A tree with a single node is considered height 1
     * O(n)
     * @return height of the tree
     */
    public int height(){
        if (getRoot() == null){
            return 0;
        }

        return getRoot().height();
    }


    /**
     * Converts a binary search tree to an array.
     * O(n)
     * @return An array representation of the bst
     */
    public List<T> toArray(){
        if (getRoot() == null) {
            return new ArrayList<>();
        }

        List<T> returnArray = new ArrayList<>();

        //T[] returnArray = (T[]) new Comparable[getCount()];
        getRoot().toArray(returnArray, 0);
        return returnArray;
    }

    /**
     * Returns true if the value is found in the tree
     * O(n)
     * @param val the value to search for
     * @return boolean true if found, false if not
     */
    public boolean contains(T val){
        if (getRoot() != null){
            return getRoot().contains(val);
        }
        return false;
    }

    /**
     * Searches and remove a value from the tree
     * O(n)
     * @param val the value to search for
     */
    public void remove(T val){
        if (getRoot() != null){
            setRoot(getRoot().remove(val));
            setCount(getCount() - 1);
        }
    }



    // method taken from CSC252 Assignment Page
    private void printMyTree(BinarySearchTree<Integer> tree)
    {
        if (tree.getRoot() == null)
        {
            System.out.println("Tree is empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(tree.getRoot().getData() + " (root)");
        String pointerRight = "└──";
        String pointerLeft = (tree.getRoot().getRight() != null) ? "├──" : "└──";
        TraverseNodes(sb, "", pointerLeft, tree.getRoot().getLeft(), tree.getRoot().getRight() != null, true);
        TraverseNodes(sb, "", pointerRight, tree.getRoot().getRight(), false, false);
        System.out.println(sb.toString());
    }

    private void TraverseNodes(StringBuilder sb, String padding, String pointer, Node<Integer> node, boolean hasRightSibling, boolean isLeftNode)
    {
        if (node != null)
        {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            //This is where we print the data and if it is left or right child
            sb.append(node.getData() + (isLeftNode ? "(L)" : "(R)"));
            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling)
            {
                paddingBuilder.append("│ ");
            }
            else
            {
                paddingBuilder.append(" ");
            }
            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";
            TraverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null, true);
            TraverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false, false);
        }
    }

        }
