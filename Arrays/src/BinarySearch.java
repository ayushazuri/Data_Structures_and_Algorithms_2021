public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int search = 2;
        int len = a.length;
        int start = 0, end = len - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(a[mid] == search){
                System.out.println("Element found at " + mid);
                break;
            }
            else if(a[mid] > search)
                end = mid - 1;
            else if(a[mid] < search)
                start = mid + 1;
        }
    }
}
