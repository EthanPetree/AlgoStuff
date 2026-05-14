package edu.neumont.csc252.data_structures.stacks_queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTests {
    // push
    @Test
    public void stack_PushManyItemsHasLastItemOnTop() {
        Stack<Integer> stack = new Stack<>();
        int expected = 30;

        stack.push(10);
        stack.push(20);
        stack.push(expected);

        assertEquals(expected, stack.peek());
    }

    @Test
    public void stack_SingleItemIncreasesCountToOne() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);

        assertEquals(1, stack.count());
    }

    //pop
    @Test
    public void stack_PopReturnsTopItem() {
        Stack<Integer> stack = new Stack<>();
        int expected = 12;

        stack.push(10);
        stack.push(12);

        assertEquals(expected, stack.pop());
    }

    @Test
    public void stack_PopDecreasesCount() {
        Stack<Integer> stack = new Stack<>();
        int expected = 1;
        stack.push(10);
        stack.push(110);
        stack.pop();

        assertEquals(expected, stack.count());
    }

    // peak
    @Test
    public void stack_PeekReturnsTopWithoutRemoving() {
        Stack<Integer> stack = new Stack<>();
        int expected = 2;
        stack.push(10);
        stack.push(110);
        stack.peek();

        assertEquals(expected, stack.count());
    }

    @Test
    public void stack_PeekWorksAfterPopCalled() {
        Stack<Integer> stack = new Stack<>();
        int expected = 10;
        stack.push(10);
        stack.push(110);
        stack.pop();

        assertEquals(expected, stack.peek());
    }

    // contains
    @Test
    public void stack_ContainsItemExistsTRUE(){
        Stack<Integer> stack = new Stack<>();

        stack.push(42);
        stack.push(84);

        assertTrue(stack.contains(42));
    }

    @Test
    public void stack_ContainsItemDoesNotExist(){
        Stack<Integer> stack = new Stack<>();

        stack.push(43);
        stack.push(84);

        assertFalse(stack.contains(42));
    }

    //get
    @Test
    public void stack_GetValidIndexReturnsCorrectItem(){
        Stack<Integer> stack = new Stack<>();
        int expected = 58;

        stack.push(42);
        stack.push(58);
        stack.push(84);

        assertEquals(expected, stack.get(1));
    }

    @Test
    public void stack_GetWorksSameAsPeak(){
        Stack<Integer> stack = new Stack<>();

        stack.push(42);
        stack.push(58);
        stack.push(84);

        assertEquals(stack.peek(), stack.get(0));
    }

    // count
    @Test
    public void stack_CountWorksOnEmpty() {
        Stack<Integer> stack = new Stack<>();

        assertEquals(0, stack.count());
    }

    @Test
    public void stack_CountWorksAfterMultipleOperations() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);

        assertEquals(3, stack.count());
    }
}