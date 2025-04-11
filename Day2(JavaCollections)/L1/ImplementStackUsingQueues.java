package JavaCollections.Queues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> mainQueue;
    Queue<Integer> helperQueue;

    public MyStack() {
        mainQueue = new LinkedList<>();
        helperQueue = new LinkedList<>();
    }

    public void push(int x) {
        // Add new element to helper queue
        helperQueue.offer(x);

        // Transfer all elements from main queue to helper queue
        while (!mainQueue.isEmpty()) {
            helperQueue.offer(mainQueue.poll());
        }

        // Swap the queues
        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;
    }

    public int pop() {
        if (mainQueue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return mainQueue.poll();
    }

    public int top() {
        if (mainQueue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return mainQueue.peek();
    }

    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }
}

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Should print 3
        System.out.println("Pop: " + stack.pop()); // Should print 3
        System.out.println("Pop: " + stack.pop()); // Should print 2
    }
}