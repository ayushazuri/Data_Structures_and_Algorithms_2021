public class FirstAndLastOccuranceOfElement {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 10, 10, 10, 10, 15, 16};
        int search = 10;
        int n = a.length;
        System.out.println("First Occurrence at " + firstOccurrence(a, n, search));
        System.out.println("Last Occurrence at " + lastOccurrence(a, n, search));
    }

    public static int firstOccurrence(int[] a, int n, int search){
        int start = 0, end = n - 1, res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(a[mid] == search){
                res = mid;
                end = mid - 1;
            }else if(a[mid] > search){
                end = mid - 1;
            }else if(a[mid] < search){
                start = mid + 1;
            }
        }
        return res;
    }

    public static int lastOccurrence(int[] a, int n, int search){
        int start = 0, end = n - 1, res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(a[mid] == search){
                res = mid;
                start = mid + 1;
            }else if(a[mid] > search){
                end = mid - 1;
            }else if(a[mid] < search){
                start = mid + 1;
            }
        }
        return res;
    }
}
