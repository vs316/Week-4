package java_regex;

import java.util.Stack;

public class RegexExample {
    public static void main(String[] args) {
        int arr[] = {15, 4, 6, 1, 3, 150};
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            // Remove elements from the stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // If the stack is empty, no greater element exists; otherwise, the top of the stack is the next greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        // Print the result array
        System.out.println("Next greatest elements: ");
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
