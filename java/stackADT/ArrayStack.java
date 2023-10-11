import java.util.List;

public class ArrayStack<E> implements StackADT<E>
{
    int top;
    public E[] Stack;

    /**
     * Constructor for objects of class ArrayStack
     */
    public ArrayStack(int capacity) {
        top = -1;
        Stack = (E[]) new Object[capacity];
        // Casting is used in the above as generic arrays cannot be created using new E[]
    }

    public ArrayStack(){
        this(3);
    }

    public void push(E element){
        if (top == Stack.length - 1){
            throw new FullStackException("List is full, so cannot add an item to the list");
        }

        top++;
        Stack[top] = element;
    }


    public E pop(){
        E element;

        if (isEmpty()) {
            throw new EmptyStackException("List is empty, so cannot remove item from list");
        }

        element = Stack[top];

        Stack[top] = null;
        top--;

        return element;
    }

    public E top(){
        if (isEmpty()) {
            throw new EmptyStackException("List is empty, so cannot return top item from the list");
        }

        return Stack[top];
    }

    public int size(){
        return top + 1;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
