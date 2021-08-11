import java.util.Arrays;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] s = {"zebra", "dog", "duck", "dove"};
        String[] res = uniquePrefix(s);

        System.out.println(Arrays.toString(res));
    }

    static String[] uniquePrefix(String[] a){
        String[] res = new String[a.length];
        int size = res.length;
        Arrays.sort(a);

        int j = 0;
        while(j <Math.min(a[0].length() -1, a[1].length()-1)){
            if (a[0].charAt(j) == a[1].charAt(j))
                j++;
            else
                break;
        }

        res[0] = a[0].substring(0, j+1);
        String old_prefix = a[1].substring(0,j+1);

        for(int i=1;i<size-1;i++){
            j = 0;
            while(j <Math.min(a[i].length() -1, a[i+1].length()-1)){
                if (a[i].charAt(j) == a[i+1].charAt(j))
                    j++;
                else
                    break;
            }
            String new_prefix = a[i].substring(0, j+1);
            if(old_prefix.length() > new_prefix.length())
                res[i] = old_prefix;
            else
                res[i] = new_prefix;

            old_prefix = a[i+1].substring(0, j+1);
        }

        j = 0;
        while(j <Math.min(a[size-2].length() -1, a[size-1].length()-1)){
            if (a[size-2].charAt(j) == a[size-1].charAt(j))
                j++;
            else
                break;
        }
        res[size-1] = a[size-1].substring(0, j+1);
        return res;
    }
}
