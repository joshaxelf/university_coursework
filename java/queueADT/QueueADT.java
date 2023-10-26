public interface QueueADT<E> {
    /**
     * may throw FullQueueException
     */
    void enqueue(E element);

    /**
     * throws EmptyQueueException
     */
    E dequeue();

    /**
     * throws EmptyQueueException
     */
    E front();

    int size();

    boolean isEmpty();
}
