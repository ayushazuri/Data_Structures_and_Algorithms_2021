public class AllocatePages {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int totalStudents = 2;
        System.out.println(allocatePages(a, a.length, totalStudents));
    }

    public static int allocatePages(int[] a, int n, int totalStudents){
        int max = 0, sum = 0;
        for(int i: a){
            max = Math.max(max, i);
            sum += i;
        }

        int low = max, high = sum, res = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(isValid(a, n, mid, totalStudents)){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }

    public static boolean isValid(int[] a, int n, int mid, int totalStudents){
        int sum=0, totalSlot = 1;
        for(int i: a){
            sum += i;
            if(sum > mid){
                totalSlot++;
                sum = i;
            }
        }
        if(totalSlot <= totalStudents)
            return true;
        return false;
    }
}
