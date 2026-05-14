package edu.neumont.csc252.data_structures.stacks_queues;

import edu.neumont.csc252.data_structures.single_linked_list.SingleLinkedList;
/* Statement:
Linked lists work so well with stacks and queues as they provide quick access to the head and tail of our lists,
and do not require that we insert items into the middle of these lists.
 */
public class Stack <T extends Comparable <T>> {
    private SingleLinkedList<T> list;

    public Stack() {
        setList(new SingleLinkedList<>());
    }

    public void setList(SingleLinkedList<T> list) {
        this.list = list;
    }

    /**
     * Gets a value from the stack
     * O(n)
     * @param index the index to grab
     * @return the value at the index
     */
    public T get(int index){
        return list.get(index);
    }

    /**
     * Returns if an item is contained in the stack or not
     * O(n)
     * @param val the value we are finding to confirm if its in the stack
     * @return true if found false otherwise
     */
    public boolean contains(T val){
        int result = list.search(val);
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Grabs the value of the top item in the stack
     * O(1)
     * @return the value of the top item in the stack
     */
    public T peek(){
        return get(0);
    }

    /**
     * Removes the top item in the stack
     * O(1)
     * @return the value of the top item
     */
    public T pop(){
        return list.remove();
    }

    /**
     * Adds a new item to the top of the stack
     * O(1)
     * @param val the value to be inserted
     */
    public void push(T val){
        list.insertAt(val, 0);
    }

    /**
     * Gets the count of the stack
     * O(1)
     * @return integer count of the number of items in the stack
     */
    public int count(){
        return list.getCount();
    }

}
