//Make a variable which can retrieve the last number by doing some manipulation to the actual number.

import java.util.Stack;

public class MinStackWithoutSpace {
    static int minValue;
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        MinStackWithoutSpace s = new MinStackWithoutSpace();
        s.addValue(stack,5);
        System.out.println(minValue);
        s.addValue(stack,7);
        System.out.println(minValue);

        s.addValue(stack, 2);
                System.out.println(minValue);

        s.popValue(stack);
        System.out.println(minValue);
        System.out.println(s.getTop(stack));

        s.popValue(stack);
        System.out.println(minValue);
        System.out.println(s.getTop(stack));



    }

    public static int getMinValue(Stack<Integer> stack) {
        if(stack.isEmpty())
            return -1;
        return minValue;
    }

    public static void addValue(Stack<Integer> stack, int x){
        if(stack.isEmpty()){
            stack.push(x);
            minValue = x;
        }else{
            if(x >= minValue)
                stack.push(x);
            else{
                stack.push(2*x-minValue);
                minValue = x;
            }

        }
    }

    public static void popValue(Stack<Integer> stack){
        if(stack.isEmpty()){
            System.out.println("nOt possible");
        }else{
            int x = stack.pop();
            if(x < minValue){
                minValue = 2*minValue - x;
            }
        }
    }

    public static int getTop(Stack<Integer> stack){
        if(stack.isEmpty()){
            return -1;
        }else{
            if(stack.peek() >= minValue)
                return stack.peek();
            else
                return minValue;
        }
    }
}
