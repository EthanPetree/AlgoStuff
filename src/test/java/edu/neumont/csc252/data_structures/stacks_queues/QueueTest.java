package edu.neumont.csc252.data_structures.stacks_queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    // enqueue
    @Test
    public void queue_EnqueueManyItemsHasFirstItemAtFront() {
        Queue<Integer> queue = new Queue<>();
        int expected = 10;

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(expected, queue.peek());
    }

    @Test
    public void queue_SingleItemIncreasesCountToOne() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);

        assertEquals(1, queue.count());
    }

    // dequeue
    @Test
    public void queue_DequeueReturnsFrontItem() {
        Queue<Integer> queue = new Queue<>();
        int expected = 10;

        queue.enqueue(10);
        queue.enqueue(12);

        assertEquals(expected, queue.dequeue());
    }

    @Test
    public void queue_DequeueDecreasesCount() {
        Queue<Integer> queue = new Queue<>();
        int expected = 1;

        queue.enqueue(10);
        queue.enqueue(110);
        queue.dequeue();

        assertEquals(expected, queue.count());
    }

    // peek
    @Test
    public void queue_PeekReturnsFrontWithoutRemoving() {
        Queue<Integer> queue = new Queue<>();
        int expected = 2;

        queue.enqueue(10);
        queue.enqueue(110);
        queue.peek();

        assertEquals(expected, queue.count());
    }

    @Test
    public void queue_PeekWorksAfterDequeueCalled() {
        Queue<Integer> queue = new Queue<>();
        int expected = 110;

        queue.enqueue(10);
        queue.enqueue(110);
        queue.dequeue();

        assertEquals(expected, queue.peek());
    }

    // contains
    @Test
    public void queue_ContainsItemExistsTRUE(){
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(42);
        queue.enqueue(84);

        assertTrue(queue.contains(42));
    }

    @Test
    public void queue_ContainsItemDoesNotExist(){
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(43);
        queue.enqueue(84);

        assertFalse(queue.contains(42));
    }

    // get
    @Test
    public void queue_GetValidIndexReturnsCorrectItem(){
        Queue<Integer> queue = new Queue<>();
        int expected = 58;

        queue.enqueue(42);
        queue.enqueue(58);
        queue.enqueue(84);

        assertEquals(expected, queue.get(1));
    }

    @Test
    public void queue_GetWorksSameAsPeek(){
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(42);
        queue.enqueue(58);
        queue.enqueue(84);

        assertEquals(queue.peek(), queue.get(queue.count() - 1));
    }

    // count
    @Test
    public void queue_CountWorksOnEmpty() {
        Queue<Integer> queue = new Queue<>();

        assertEquals(0, queue.count());
    }

    @Test
    public void queue_CountWorksAfterMultipleOperations() {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);

        assertEquals(3, queue.count());
    }

}