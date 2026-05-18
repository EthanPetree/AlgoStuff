package edu.neumont.csc252.data_structures.binary_search_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    //add
    @Test
    void BST_CanAddRootNode(){
        //Arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int expected = 67;
        String expectedInOrderString = String.valueOf(expected);
        //Act
        bst.add(expected);

        //Assert
        assertEquals(expectedInOrderString, bst.inOrder());
    }

    @Test
    void BST_CanAddMultipleValues(){
        //Arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        String expected = "25, 50, 75";

        //Act
        bst.add(50);
        bst.add(25);
        bst.add(75);

        //Assert
        assertEquals(expected, bst.inOrder());
    }

    //count
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
    void BST_CountWorksWithRemove(){
        //Arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int expected = 2;

        //Act
        bst.add(50);
        bst.add(25);
        bst.add(75);

        bst.remove(25);

        //Assert
        assertEquals(expected, bst.getCount());
    }


    //clear
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
        String expected = "";

        //Act
        bst.clear();

        //Assert
        assertEquals(expected, bst.inOrder());
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
        assertEquals(0, bst.getCount());
    }

    // InOrder
    @Test
    void BST_inOrderReturnsProperString(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(20);
        bst.add(100);
        bst.add(10);
        bst.add(25);
        String expected = "10, 20, 25, 50, 100";

        //act
        String actual = bst.inOrder();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void BST_inOrderReturnsEmptyOnEmptyTree(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        String expected = "";

        //act
        String actual = bst.inOrder();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void BST_inOrderReturnsProperStringOnLeftHeavyString(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(40);
        bst.add(30);
        bst.add(20);
        bst.add(10);
        String expected = "10, 20, 30, 40, 50";

        //act
        String actual = bst.inOrder();

        //assert
        assertEquals(expected, actual);
    }

// preorder
@Test
void BST_preOrderReturnsProperString(){
    //arrange
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.add(50);
    bst.add(20);
    bst.add(100);
    bst.add(10);
    bst.add(25);
    String expected = "50, 20, 10, 25, 100";

    //act
    String actual = bst.preOrder();

    //assert
    assertEquals(expected, actual);
}

    @Test
    void BST_preOrderReturnsEmptyOnEmptyTree(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        String expected = "";

        //act
        String actual = bst.preOrder();

        //assert
        assertEquals(expected, actual);
    }

    //postorder
    @Test
    void BST_postOrderReturnsProperString(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(20);
        bst.add(100);
        bst.add(10);
        bst.add(25);
        String expected = "10, 25, 20, 100, 50";

        //act
        String actual = bst.postOrder();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void BST_postOrderReturnsEmptyOnEmptyTree(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        String expected = "";

        //act
        String actual = bst.postOrder();

        //assert
        assertEquals(expected, actual);
    }

    //to array
    @Test
    void BST_toArrayReturnsProperArrayInPopulatedTree(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(20);
        bst.add(70);
        Integer[] expected = {20, 25, 50, 70, 75};

        var actual = bst.toArray();

        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void BST_toArrayHandlesEmptyArray(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] expected = {};

        var actual = bst.toArray();

        assertArrayEquals(expected, actual.toArray());
    }

    //remove
    @Test
    void BST_removeWorksOnBasicArray(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(20);
        bst.add(100);
        bst.add(10);
        bst.add(25);

        //act
        bst.remove(20);

        //assert
        assertFalse(bst.contains(20));
    }

    @Test
    void BST_removeShiftsAllNodesCorrectlyAfterRemovingHead(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(20);
        bst.add(100);
        bst.add(10);
        bst.add(25);
        Integer[] expected = {10, 20, 25, 100};

        //act
        bst.remove(50);
        var actual = bst.toArray();

        //assert
        assertArrayEquals(expected, actual.toArray());
    }


    //contains
    @Test
    void BST_containsWorksOnBasicArrayWithNumber(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(20);
        bst.add(70);

        boolean actual = bst.contains(20);

        assertTrue(actual);
    }

    @Test
    void BST_containsWorksOnBasicArrayWithNumberNotInArray(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(20);
        bst.add(70);

        boolean actual = bst.contains(21);

        assertFalse(actual);
    }

    @Test
    void BST_containsWorksOnEmptyArray(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        boolean actual = bst.contains(20);

        assertFalse(actual);
    }

    //height
    @Test
    void BST_heighIsProperlyCalculated(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(40);
        bst.add(30);
        bst.add(20);
        bst.add(10);
        int expected = 5;

        //act
        int actual = bst.height();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void BST_heighIsProperlyCalculatedOnEmptyTree(){
        //arrange
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int expected = 0;

        //act
        int actual = bst.height();

        //assert
        assertEquals(expected, actual);
    }
}