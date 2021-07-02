//For all the blocks, we need to find the total water that would be trapped in the empty areas which is enclosed by the blocks. The trick is simple =>
//    1. For each block find the greatest block on the left and the greatest block on the right,
//        because this will be the total area in which the water be trapped, and this will also give the level of the water.
//    2. To get the max level of the water, just take the minimum of the two greatest blocks on the left and right. That would be the level.
//    3. Now calculate the area of water in a particular vertical block for all the element,
//        by subtracting the level of water from the height of the block, above which you want to calc the water.
//    4. Add all the area of water found above each block.


import java.util.Arrays;

public class RainTrapping {
    public static void main(String[] args) {
        int[] a = {3, 0 ,0 ,2, 0, 4};
        System.out.println(rainTrapping(a));

    }

    public static int rainTrapping(int[] a){
        int[] maxR = greaterToTheRight(a);
        int[] maxL = greaterToTheLeft(a);
        System.out.println(Arrays.toString(maxR));
        System.out.println(Arrays.toString(maxL));
        int len = a.length;
        int[] res = new int[a.length];
        int sum = 0;
        for(int i = 0; i < len; i++){
            res[i] = Math.min(maxL[i], maxR[i]) - a[i];
            sum += res[i];
        }
        return sum;
    }

    public static int[] greaterToTheRight(int[] a){
        int len = a.length;
        int[] res = new int[a.length];
        int max = a[len - 1];
        for(int i = len - 1; i >= 0; i--){
            if(a[i] > max){
                max = a[i];
            }
            res[i] = max;
        }
        return res;
    }

    public static int[] greaterToTheLeft(int[] a){
        int len = a.length;
        int[] res = new int[a.length];
        int max = a[0];
        for(int i = 0; i < len; i++){
            if(a[i] > max){
                max = a[i];
            }
            res[i] = max;
        }
        return res;
    }
}
