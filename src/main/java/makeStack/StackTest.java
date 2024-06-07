package makeStack;

public class StackTest {
    public StackTest() {
    }

    public static void main(String[] args) {
        StackMake stack = new StackMake();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        stack.push(110);
        //System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        //System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.display());
        //System.out.println(stack);
    }
}
