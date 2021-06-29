import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class SmallestNearestToRight_Left {
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 3, 2, 3, 4};
        smallestToTheRight(arr);
        smallestToTheLeft(arr);
    }
    public static void smallestToTheRight(int[] arr){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = arr.length -1; i>=0; i--){
            if(stack.isEmpty())
                al.add(-1);
            else if(stack.peek() < arr[i])
                al.add(stack.peek());
            else if(stack.peek() >= arr[i]){
                while(!stack.isEmpty() && stack.peek() >= arr[i])
                    stack.pop();
                if(stack.isEmpty())
                    al.add(-1);
                else
                    al.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        Collections.reverse(al);
        System.out.println(al);
    }
    public static void smallestToTheLeft(int[] arr){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0; i<arr.length; i++) {
            if (stack.isEmpty())
                al.add(-1);
            else if (stack.peek() < arr[i])
                al.add(stack.peek());
            else if (stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i])
                    stack.pop();
                if (stack.isEmpty())
                    al.add(-1);
                else
                    al.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        System.out.println(al);
    }
}
