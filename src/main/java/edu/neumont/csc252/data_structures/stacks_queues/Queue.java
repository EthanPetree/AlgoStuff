package edu.neumont.csc252.data_structures.stacks_queues;

import edu.neumont.csc252.data_structures.double_linked_list.DoubleLinkedList;

/* Statement:
Linked lists work so well with stacks and queues as they provide quick access to the head and tail of our lists,
and do not require that we insert items into the middle of these lists.
 */
public class Queue <T extends Comparable <T>> {
    DoubleLinkedList<T> list;

    public Queue() {
        setList(new DoubleLinkedList<>());
    }

    public void setList(DoubleLinkedList<T> list) {
        this.list = list;
    }

    /**
     * Gets a value from the queue
     * O(n)
     * @param index the index to grab
     * @return the value at the index
     */
    public T get(int index){
        return list.get(index);
    }

    /**
     * Returns if an item is contained in the queue or not
     * O(n)
     * @param val the value we are finding to confirm if its in the queue
     * @return true if found false otherwise
     */
    public boolean contains(T val){
        int result = list.search(val);
        return result != -1; //intelij did this
    }

    /**
     * Grabs the value of the bottom item in the queue
     * O(1)
     * @return the value of the bottom item in the queue
     */
    public T peek(){
        return list.getTail().getData(); // better way?
    }

    /**
     * Removes the bottom item in the queue
     * O(1)
     * @return the value of the bottom item
     */
    public T dequeue(){
        return list.removeLast();
    }

    /**
     * Adds a new item to the top of the queue
     * O(1)
     * @param val the value to be inserted
     */
    public void enqueue(T val){
        list.insertAt(val, 0);
    }

    /**
     * Gets the count of the queue
     * O(1)
     * @return integer count of the number of items in the queue
     */
    public int count(){
        return list.getCount();
    }
}
