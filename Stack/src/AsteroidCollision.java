import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    static int[] asteroidCollison(int[] a){
        Stack<Integer> stack = new Stack<>();
        for(int i: a){
            if(i > 0)
                stack.push(i);
            else{
                while(!stack.isEmpty() && stack.peek() >= 0 && Math.abs(i) > Math.abs(stack.peek()))
                    stack.pop();

                if(stack.isEmpty() || stack.peek() < 0)
                    stack.push(i);
                else if(stack.peek() == Math.abs(i))
                    stack.pop();
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a ={5, 10, -5};
        int[] res = asteroidCollison(a);
        System.out.println(Arrays.toString(res));
    }
}

