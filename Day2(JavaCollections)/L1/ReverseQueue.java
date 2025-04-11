
package JavaCollections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    private static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseQueue(queue);
        System.out.println(queue);
    }
}

