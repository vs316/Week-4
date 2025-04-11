
package JavaCollections.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNBinaryNumbersAsStringsUsingQueues {
    public String[] generateBinaryNumbers(int n) {
        if (n <= 0) {
            return new String[0];
        }

        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            result[i] = queue.poll();
            queue.offer(result[i] + "0");
            queue.offer(result[i] + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        GenerateNBinaryNumbersAsStringsUsingQueues generator = new GenerateNBinaryNumbersAsStringsUsingQueues();

        // Test with n = 5
        String[] binaryNumbers = generator.generateBinaryNumbers(5);
        System.out.println("First 5 binary numbers:");
        for (String num : binaryNumbers) {
            System.out.println(num);
        }
    }
}

