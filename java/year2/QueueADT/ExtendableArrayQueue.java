/**
 * This class is for completion in Practical 3ii
 */
public class ExtendableArrayQueue<E> implements QueueADT<E> {
    protected E[] queue; // Q will refer to the array
    protected int front; // front - array index of element at front of queue
    protected int rear; // rear - array index of where next element added will be placed
    protected int maxItems;  // array capacity

    /**
     * Constructor for objects of class ExtendableArrayQueue.
     * In practical 3ii no change need be made to this constructor.
     * With this constructor a queue can initially hold up to
     * 3 (i.e.N-1) items when using the approach described in lectures.
     */
    public ExtendableArrayQueue() {
        maxItems = 4;
        queue = (E[]) new Object[maxItems];
        front = 0;
        rear = 0;
    }

    // Complete the method bodies below and add any further methods if
    // appropriate. Many of the method bodies can be the same as in Q3i

    public void enqueue(E element) {
        if (size() == maxItems - 1) {

            // Declaring integer for oldQueue to store the size of old array
            int oldQueue;
            oldQueue = maxItems;
            maxItems = maxItems + 1;

            // Create new array
            E[] newQueue = (E[]) new Object[maxItems];

            // Copying the array elements over
            for (int i = 0; i < oldQueue; i++) {
                newQueue[i] = queue[front];
                front = (front + 1) % oldQueue;
            }

            // Assign new queue to variable queue so rest of program still runs
            queue = newQueue;
            front = 0;
            rear = oldQueue - 1;

        }
        // Return element and adjust queue
        queue[rear] = element;
        rear = (rear + 1) % maxItems;
    }

    /**
     * @throws EmptyQueueException
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty, cannot dequeue");
        } else {
            E element = queue[front];
            front = (front + 1) % maxItems;
            return element;
        }
    }

    /**
     * @throws EmptyQueueException
     */
    public E front() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty, cannot return element");
        } else {
            return queue[front];
        }
    }

    public int size() {
        return (maxItems - front + rear) % maxItems;
    }

    public boolean isEmpty() {
        return (front == rear);
    }
}
