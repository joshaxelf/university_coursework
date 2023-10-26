/**
 * This class is for completion in practical 3 part i
 */
public class ArrayQueue<E> implements QueueADT<E> {
    protected E[] queue; // Q will refer to the array
    protected int front; // front - array index of element at front of queue
    protected int rear; // rear - array index of where next element added will be placed
    protected int maxItems;  // array capacity

    /**
     * Constructor for objects of class ArrayQueue.
     * In practical 3i no change need be made to this constructor.
     * With this constructor a queue can hold up to 3 (i.e.N-1) items when
     * using the approach described in lectures.
     */
    public ArrayQueue() {
        maxItems = 4;
        queue = (E[]) new Object[maxItems];
        front = 0;
        rear = 0;
    }

    /**
     * In practical 3i complete the methods below using an array
     * implementation where the queue is considered full if the
     * queue size is one less than the array capacity. Pseudocode
     * is provided in MyPlace Activity 4.10 slides 7 and 8.
     * Take care that exceptions to the correct types are
     * thrown by your methods as specified in the method comments.
     * <p>
     * /**
     *
     * @throws FullQueueException
     */
    public void enqueue(E element) {
        if (size() == maxItems - 1) {
            throw new FullQueueException("Queue is full, cannot add to queue");
        } else {
            queue[rear] = element;
            rear = (rear + 1) % maxItems;
        }
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
            throw new EmptyQueueException("Queue is empty");
        } else {
            return queue[front];
        }
    }

    public int size() {
        return (maxItems - front + rear) % maxItems;
    }

    public boolean isEmpty() {
        return front == rear;
    }
}
