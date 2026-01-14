package DSA;

import java.util.Stack;

class SortStackUsingRecursion {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();

            // Sort remaining stack
            sortStack(stack);

            // Insert the element at correct position
            insertSorted(stack, top);
        }
    }

    // Helper function to insert element in sorted order
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base condition
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertSorted(stack, element);
        stack.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
