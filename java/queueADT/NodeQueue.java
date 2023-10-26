/**
 * This class is for completion in Practical 3iii
 * The Node class is supplied for you
 */
public class NodeQueue<E> implements QueueADT<E> {
    // references to the head and tail of 
    // the linked list
    protected Node<E> head, tail;
    // number of elements in the queue
    protected int size;

    /**
     * constructs an empty queue
     */
    public NodeQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Complete the method bodies below. Take care
    // that exceptions of the correct types are thrown by
    // your methods as specified in the method comments.

    public int size() {
        return size; // Simply return size
    }

    public boolean isEmpty() {
        return size == 0; // Simply return true when size must equal 0
    }

    public void enqueue(E elem) {
        // Create and link in a new node at tail
        Node<E> newNode = new Node<>(elem, head);

        // If Node array is empty, make a new Node and set it to both head and tail as must = both
        if (isEmpty()) {
            head = newNode;
            tail = newNode;

            // If Node array not empty, set old tail next destination to newNode and set newNode as tail
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        // Increase size of Node array
        size++;
    }

    /**
     * @throws EmptyQueueException
     */
    public E front() {
        if (isEmpty()) {
            throw new EmptyQueueException("Node queue is empty, cannot return top value");
        } else {
            return head.getElement();
        }
    }

    /**
     * @throws EmptyQueueException
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Node queue is empty, cannot deque");
        } else {
            // Set head element to variable "removedHead" before removing
            E removedHead = head.getElement();

            // Set head to the next Node in the queue
            head = head.getNext();

            // Decrease size of the Node queue
            size--;

            // Return the element that was at head of the queue
            return removedHead;
        }
    }
}
