package edu.neumont.csc252.data_structures.binary_search_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void BST_CanAddRootNode(){
        //Arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int expected = 67;
        //Act
        bst.add(expected);

        //Assert
        assertEquals(expected, bst.getRoot().getData()); // TODO: use a get function
    }

    @Test
    void BST_CanAddMultipleValues(){
        //Arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        //Act
        bst.add(50);
        bst.add(25);
        bst.add(75);

        //Assert
        assertEquals(50, bst.getRoot().getData());
        assertEquals(25, bst.getRoot().getLeft().getData());
        assertEquals(75, bst.getRoot().getRight().getData());
    }

    @Test
    void BST_CountUpdatesProperlyWithAdd(){
        //Arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int expected = 3;

        //Act
        bst.add(50);
        bst.add(25);
        bst.add(75);

        //Assert
        assertEquals(expected, bst.getCount());
    }

    @Test
    void BST_ClearWorksOnLargeList(){
        //Arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(93);
        bst.add(3);
        bst.add(13);
        bst.add(33);
        bst.add(67);
        bst.add(420);

        //Act
        bst.clear();

        //Assert
        // TODO: fix later
        assertNull(bst.getRoot());
    }

    @Test
    void BST_ClearCorrectlyUpdatesCount(){
        //Arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(25);

        //Act
        bst.clear();

        //Assert
        // TODO: fix later
        assertEquals(0, bst.getCount());
    }


}