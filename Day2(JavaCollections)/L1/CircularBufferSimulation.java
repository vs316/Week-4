
package JavaCollections.Queues;

import java.util.ArrayDeque;

class CircularBuffer {
    private ArrayDeque<Integer> buffer;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new ArrayDeque<>(capacity);
    }

    public void write(int value) {
        if (isFull()) {
            buffer.removeFirst();
        }
        buffer.addLast(value);
    }

    public Integer read() {
        return buffer.isEmpty() ? null : buffer.removeFirst();
    }

    public ArrayDeque<Integer> getBuffer() {
        return new ArrayDeque<>(buffer);
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public boolean isFull() {
        return buffer.size() == capacity;
    }
}

public class CircularBufferSimulation {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        // Demonstrate buffer operations
        System.out.println("Adding 1, 2, 3 to buffer");
        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        System.out.println("Buffer contents: " + buffer.getBuffer());

        System.out.println("Adding 4 (should overwrite 1)");
        buffer.write(4);
        System.out.println("Buffer contents: " + buffer.getBuffer());

        System.out.println("Reading value: " + buffer.read());
        System.out.println("Buffer contents: " + buffer.getBuffer());
    }
}

