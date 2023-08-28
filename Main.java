package HW.Stack;

public class Main {


        public static void main(String[] args) {
            SpecialStack stack = new SpecialStack();
            stack.push(3);
            stack.push(5);
            stack.push(2);
            stack.push(1);
            System.out.println("Min: " + stack.getMin()); // 1
            System.out.println("Max: " + stack.getMax()); // 5
            System.out.println("Pop: " + stack.pop()); // 1
            System.out.println("Min: " + stack.getMin()); // 2
            System.out.println("Max: " + stack.getMax()); // 5
        }
    }

