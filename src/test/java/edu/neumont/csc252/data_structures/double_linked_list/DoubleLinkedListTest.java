package edu.neumont.csc252.data_structures.double_linked_list;

import edu.neumont.csc252.data_structures.single_linked_list.SingleLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    // add
    @Test
    void DLL_CanAddItemToEmptyCollection(){
        // Arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();

        // Act
        dll.add(1);

        // Assert
        assertEquals(1, dll.get(0));
    }

    @Test
    void SLL_CanAddItemToPopulatedCollection(){
        // Arrange
        DoubleLinkedList<Integer> sll = new DoubleLinkedList<>();
        sll.add(1);

        // Act
        sll.add(2);

        // Assert
        assertEquals(1, sll.get(0));
        assertEquals(2, sll.get(1));
    }

    //get
    @Test
    void SLL_GetProperlyReturnsValueAtIndex(){
        //Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        int expectedValue = 3;

        //Act
        int actualValue = sll.get(2);

        //Assert
        assertEquals(expectedValue, actualValue);
    }

    //count
    @Test
    void SLL_CountProperlyIncrementsOnAddMany(){
        // Arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        int expectedCount = 6;

        // Act
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.add(5);
        sll.add(6);
        int actualCount = sll.getCount();

        // Assert
        assertEquals(expectedCount, actualCount);
    }


    //remove
    @Test
    void SLL_RemoveThrowsExceptionOnEmptyList(){
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();

        assertThrows(IllegalStateException.class, () -> {
            sll.remove();
        });
    }

    @Test
    void SLL_RemoveRemovesHeadNodeFromCollectionWithOneItem(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        int expectedValue = 10;
        sll.add(expectedValue);

        //act
        int actualValue = sll.remove();

        //assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void SLL_RemoveProperlyReducesCountOnRemoval(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(10);

        //act
        sll.remove();

        //assert
        assertEquals(0, sll.getCount());
    }

    //remove last
    @Test
    void SLL_RemoveLastWorksWithOneItemList(){
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(10);

        //act
        sll.removeLast();

        //assert
        assertEquals(0, sll.getCount());
    }

    @Test
    void SLL_RemoveLastWorksWithSeveralItemsInList(){
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(10);
        sll.add(15);
        sll.add(20);
        sll.add(25);

        //act
        sll.removeLast();

        //assert
        assertEquals(3, sll.getCount());
    }

    @Test
    void SLL_RemoveLastRemovesCorrectItemInList(){
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(10);
        sll.add(15);
        sll.add(20);
        sll.add(25);

        //act
        int actual = sll.removeLast();

        //assert
        assertEquals(25, actual);
    }

    //remove at
    @Test
    void SLL_RemoveAtRemovesCorrectIndex(){
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(10);
        sll.add(15);
        sll.add(20);
        sll.add(25);

        //act
        int actual = sll.removeAt(1);

        //assert
        assertEquals(15, actual);
    }

    @Test
    void SLL_RemoveAtHandlesEmptyList(){
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();


        //assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            sll.removeAt(5);
        });
    }


    //insert at
    @Test
    void SLL_InsertAtZeroIndexWorksOnEmptyList(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        int expectedValue = 10;

        //act
        sll.insertAt(expectedValue, 0);
        int actualValue = sll.get(0);

        //assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void SLL_InsertAtMiddleIndexWorksOnPopulatedList(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(1);
        sll.add(2);
        sll.add(4);
        sll.add(5);
        int expectedValue = 6;

        //act
        sll.insertAt(expectedValue, 2);
        int actualValue = sll.get(2);
        int nextIndexValue = sll.get(3);

        //assert
        assertEquals(expectedValue, actualValue);
        assertEquals(4, nextIndexValue);
    }

    @Test
    void SLL_InsertAtProperlyIncreasesCount(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(1);
        sll.add(3);
        sll.add(4);
        int expectedCount = 4;

        //act
        sll.insertAt(2, 1);

        //assert
        assertEquals(expectedCount, sll.getCount());
    }

    //to string
    @Test
    void SLL_ToStringWorksOnSimpleList(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.add(5);
        sll.add(6);
        String expected = "1, 2, 3, 4, 5, 6";

        // act
        String actual = sll.toString();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void SLL_ToStringWorksOnEmptyList(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        String expected = "";

        // act
        String actual = sll.toString();

        //assert
        assertEquals(expected, actual);
    }

    //clear
    @Test
    void SLL_ClearProperlyClearsPopulatedList(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(1);
        sll.add(3);
        sll.add(4);

        //act
        sll.clear();

        //assert
        assertEquals(0, sll.getCount());
    }

    @Test
    void SLL_ClearProperlyClearsEmptyList(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();

        //act
        sll.clear();

        //assert
        assertEquals(0, sll.getCount());
    }

    //search
    @Test
    void SLL_SearchReturnsValueInSimpleList(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);

        //act
        int actual = sll.search(3);

        //assert
        assertEquals(2, actual);
    }

    @Test
    void SLL_SearchReturnsInvalidIndexIfValueNotFound(){
        //arrange
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);

        //act
        int actual = sll.search(5);

        //assert
        assertEquals(-1, actual);
    }

}