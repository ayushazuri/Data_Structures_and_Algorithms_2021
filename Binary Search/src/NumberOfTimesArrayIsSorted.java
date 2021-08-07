public class NumberOfTimesArrayIsSorted {
    public static void main(String[] args) {
        int[] a = {5, 6, 7, 8, 9, 10, 1, 2};

        int len = a.length;
        int start = 0, end = len - 1;
        int res = -1;
        while(start <= end){
//            if(a[start] < a[end]){
//                res = start;
//                break;
//            }
            int mid = start + (end - start)/2;
            int next = (mid + 1) % len;
            int prev = (mid - 1 + len) % len;
            if(a[mid] <= a[next] && a[mid] <= a[prev]){
                res = mid;
                break;
            }
            else if(a[mid] > a[start])
                start = mid + 1;
            else if(a[mid] < a[end])
                end = mid - 1;
        }

        System.out.println(a[res]);
    }
}
