// Not correct
import java.util.ArrayList;

public class SortAnArrayRecursion {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(5);
        al.add(0);
        al.add(2);
        int temp = 2;
//        System.out.println(al.get(al.size() - 1) <= temp);
        sort(al);
    }

    public static void sort(ArrayList<Integer> al){
        if(al.size() == 1)
            return;

        Integer temp = al.remove(al.size() - 1);
        sort(al);
        insert(al, temp);
    }

    public static void insert(ArrayList al, Integer temp){
        int val = (int) al.get(al.size() - 1);

        if( al.size() == 0 || val <= temp) {
            al.add(temp);
            return;
        }
        Integer temp1 = (Integer) al.remove(al.size() - 1);
        insert(al, temp);
        al.add(temp1);

    }
}
