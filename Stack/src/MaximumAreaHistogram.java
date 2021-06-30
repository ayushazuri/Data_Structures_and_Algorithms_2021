/*The Trick here to calculate the maximum area histogram is to calculate the nearest smallest value to the right and left for each block,
        which would give us the width of a block, and using the block height and max width,
        we can calculate the area. We need to calculate the nearest smallest to the right and left because,
        that would tell us that if the difference between the left and right is only 1 then that will mean that block is standing alone,
        if the nearest smallest is far away, it means width will be bigger,
        as it is covering more area. So this way we can calculate the max area histogram. Note: Add a pseudoIndex which means an extra imaginary
        block before and after the first and last block, this imaginary block will basically mean that there is a block before first block of
        height 0, at index -1, and a block of height 0 after last block at index length+1.*/

/*Steps:
    1. Find an array of nearest smallest to the right
    2. Find an array of nearest smallest to the left
    3. Calculate width array using formula = right[i] - left[i] - 1
    4. multiply given array and the width to get each area and get the maximum one.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaximumAreaHistogram {
    public static void main(String[] args) {
        int[] a = {6, 2, 5, 4, 5, 1, 6};
        ArrayList<Integer> right = smallestToTheRight(a);
        ArrayList<Integer> left = smallestToTheLeft(a);

        int[] width = new int[a.length];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            width[i] = right.get(i) - left.get(i) - 1;
            maxArea = Math.max(maxArea, a[i]*width[i]);

        }
        System.out.println(maxArea);
    }

    public static ArrayList<Integer> smallestToTheRight(int[] arr){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        int pseudoIndex = arr.length;

        for(int i = arr.length -1; i>=0; i--){
            if(stack.isEmpty())
                al.add(pseudoIndex);
            else if(stack.peek() < arr[i])
                al.add(index.peek());
            else if(stack.peek() >= arr[i]){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                    index.pop();
                }
                if(stack.isEmpty())
                    al.add(pseudoIndex);
                else
                    al.add(index.peek());
            }
            stack.push(arr[i]);
            index.push(i);
        }
        Collections.reverse(al);
        System.out.println("Smallest to the right " + al);
        return al;
    }

    public static ArrayList<Integer> smallestToTheLeft(int[] arr){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        int pseudoIndex = -1;

        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty())
                al.add(pseudoIndex);
            else if(stack.peek() < arr[i])
                al.add(index.peek());
            else if(stack.peek() >= arr[i]){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                    index.pop();
                }
                if(stack.isEmpty())
                    al.add(pseudoIndex);
                else
                    al.add(index.peek());
            }

            stack.push(arr[i]);
            index.push(i);
        }
        System.out.println("Smallest to the left " + al);
        return al;
    }
}
