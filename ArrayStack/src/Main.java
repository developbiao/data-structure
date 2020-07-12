public class Main {

    public static void main(String[] args) {
        // Array stack test

        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i= 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        System.out.println("Array Stack is running!");

        // pop element
        int temp = stack.pop();
        System.out.println("Pop value:" + temp);
        System.out.println(stack);

        // pop again
        temp = stack.pop();
        System.out.println("Pop value:" + temp);
        System.out.println(stack);

    }
}
