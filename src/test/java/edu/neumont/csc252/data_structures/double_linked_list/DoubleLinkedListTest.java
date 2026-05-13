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
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);

        // Act
        dll.add(2);

        // Assert
        assertEquals(1, dll.get(0));
        assertEquals(2, dll.get(1));
    }

    @Test
    void DLL_CanAddItemToCollectionWithSeveralItems(){
        // Arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);
        dll.add(2);

        // Act
        dll.add(3);

        // Assert
        assertEquals(1, dll.get(0));
        assertEquals(2, dll.get(1));
        assertEquals(3, dll.get(2));
    }

    //get
    @Test
    void DLL_GetProperlyReturnsValueAtIndex(){
        //Arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        int expectedValue = 3;

        //Act
        int actualValue = dll.get(2);

        //Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void DLL_GetThrowsErrorIfOutOfBounds(){
        //Arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);


        //Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
           dll.get(-5);
        });
    }

    //count
    @Test
    void DLL_CountProperlyIncrementsOnAddMany(){
        // Arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        int expectedCount = 6;

        // Act
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);
        dll.add(6);
        int actualCount = dll.getCount();

        // Assert
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void DLL_CountWorksOnEmptyList(){
        // Arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        int expectedCount = 0;

        // Act

        int actualCount = dll.getCount();

        // Assert
        assertEquals(expectedCount, actualCount);
    }


    //remove
    @Test
    void DLL_RemoveThrowsExceptionOnEmptyList(){
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();

        assertThrows(IllegalStateException.class, () -> {
            dll.remove();
        });
    }

    @Test
    void DLL_RemoveRemovesHeadNodeFromCollectionWithOneItem(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        int expectedValue = 10;
        dll.add(expectedValue);

        //act
        int actualValue = dll.remove();

        //assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void DLL_RemoveProperlyReducesCountOnRemoval(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(10);

        //act
        dll.remove();

        //assert
        assertEquals(0, dll.getCount());
    }

    //remove last
    @Test
    void DLL_RemoveLastWorksWithOneItemList(){
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(10);

        //act
        dll.removeLast();

        //assert
        assertEquals(0, dll.getCount());
    }

    @Test
    void DLL_RemoveLastWorksWithSeveralItemsInList(){
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(10);
        dll.add(15);
        dll.add(20);
        dll.add(25);

        //act
        dll.removeLast();

        //assert
        assertEquals(3, dll.getCount());
    }

    @Test
    void DLL_RemoveLastRemovesCorrectItemInList(){
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(10);
        dll.add(15);
        dll.add(20);
        dll.add(25);

        //act
        int actual = dll.removeLast();

        //assert
        assertEquals(25, actual);
    }

    //remove at
    @Test
    void DLL_RemoveAtRemovesCorrectIndex(){
        SingleLinkedList<Integer> dll = new SingleLinkedList<>();
        dll.add(10);
        dll.add(15);
        dll.add(20);
        dll.add(25);

        //act
        int actual = dll.removeAt(1);

        //assert
        assertEquals(15, actual);
    }

    @Test
    void DLL_RemoveAtHandlesEmptyList(){
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();

        //assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dll.removeAt(5);
        });
    }


    //insert at
    @Test
    void DLL_InsertAtZeroIndexWorksOnEmptyList(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        int expectedValue = 10;

        //act
        dll.insertAt(expectedValue, 0);
        int actualValue = dll.get(0);

        //assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void DLL_InsertAtMiddleIndexWorksOnPopulatedList(){
        //arrange
        DoubleLinkedList<Integer> sll = new DoubleLinkedList<>();
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
    void DLL_InsertAtProperlyIncreasesCount(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);
        dll.add(3);
        dll.add(4);
        int expectedCount = 4;

        //act
        dll.insertAt(2, 1);

        //assert
        assertEquals(expectedCount, dll.getCount());
    }

    //to string
    @Test
    void DLL_ToStringWorksOnSimpleList(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);
        dll.add(6);
        String expected = "1, 2, 3, 4, 5, 6";

        // act
        String actual = dll.toString();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void DLL_ToStringWorksOnEmptyList(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        String expected = "";

        // act
        String actual = dll.toString();

        //assert
        assertEquals(expected, actual);
    }

    //clear
    @Test
    void DLL_ClearProperlyClearsPopulatedList(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);
        dll.add(3);
        dll.add(4);

        //act
        dll.clear();

        //assert
        assertEquals(0, dll.getCount());
    }

    @Test
    void DLL_ClearProperlyClearsEmptyList(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();

        //act
        dll.clear();

        //assert
        assertEquals(0, dll.getCount());
    }

    //search
    @Test
    void DLL_SearchReturnsValueInSimpleList(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        //act
        int actual = dll.search(3);

        //assert
        assertEquals(2, actual);
    }

    @Test
    void DLL_SearchReturnsInvalidIndexIfValueNotFound(){
        //arrange
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        //act
        int actual = dll.search(5);

        //assert
        assertEquals(-1, actual);
    }

}