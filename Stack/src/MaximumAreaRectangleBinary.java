/*Trick here is to convert the whole 2d array to 1d array, by calculating max histogram area for each histogram that is made,
        while going from first to last row cumulatively. While going through each row, a new row will be added to the histogram, and
        area of the histogram made by cumulative rows from first to that particular row will be calculated. so for 4 row 2d array, 4 histogram area
         will be calculated, and the largest of them all will be the maximum area rectangle. One trick present here is that, if any value comes out
          to be zero, then that cumulative some for that column will be taken as zero because as it is zero, there can't be an array which missing
          blocks.*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaximumAreaRectangleBinary {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0}, {1,1,1,1}, {1,1,1,1}, {1,1,0,0}};
        int maxArea = Integer.MIN_VALUE, histoArea = 0;
        int[] histo = new int[arr[0].length];

        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Area of each histogram");

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++) {
                if(arr[i][j] != 0)
                    histo[j] += arr[i][j];
                else
                    histo[j] = 0;
            }
            histoArea = maximumAreaHistogram(histo);
            System.out.print(histoArea + " ");
            maxArea = Math.max(maxArea, histoArea);
        }
        System.out.println();
        System.out.println(maxArea);
    }

    public static int maximumAreaHistogram(int[] arr){
        ArrayList<Integer> right = smallestToTheRight(arr);
        ArrayList<Integer> left = smallestToTheLeft(arr);

        int[] width = new int[arr.length];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            width[i] = right.get(i) - left.get(i) - 1;
            maxArea = Math.max(maxArea, arr[i]*width[i]);

        }
        return maxArea;
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
        return al;
    }
}
