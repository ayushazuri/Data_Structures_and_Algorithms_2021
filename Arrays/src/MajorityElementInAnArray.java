public class MajorityElementInAnArray {
    public static void main(String[] args) {
        int[] a = {5, 1, 4, 1, 1, 2, 2, 2, 2, 2, 2};
        int res1 = bruteMethod(a);
        System.out.println(res1);
    }

    public static int bruteMethod(int[] a){
        int n = a.length;
        int res = 0;
        int maxFreq = 0;
        for (int i : a) {
            int freq = 0;
            for (int j : a) {
                if (i == j) {
                    freq++;
                }
            }
            if (freq > maxFreq) {
                res = i;
                maxFreq = freq;
            }
        }
        if(maxFreq > n/2)
            return res;
        return -1;
    }
}
