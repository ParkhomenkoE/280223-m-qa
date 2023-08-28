package HW.Stack;

    import java.util.Stack;

    public class SpecialStack {
        private final Stack<Integer> stack;
        private final Stack<Integer> minStack;
        private final Stack<Integer> maxStack;

        public SpecialStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
            if (maxStack.isEmpty() || x >= maxStack.peek()) {
                maxStack.push(x);
            }
        }

        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            int x = stack.pop();
            if (x == minStack.peek()) {
                minStack.pop();
            }
            if (x == maxStack.peek()) {
                maxStack.pop();
            }
            return x;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public int getMin() {
            return minStack.isEmpty() ? -1 : minStack.peek();
        }

        public int getMax() {
            return maxStack.isEmpty() ? -1 : maxStack.peek();
        }
    }

