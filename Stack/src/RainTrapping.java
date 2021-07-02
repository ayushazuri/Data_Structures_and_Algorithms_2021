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
