//https://www.youtube.com/watch?v=M65xBewcqcI&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=9&ab_channel=takeUforward
public class SetZeroMatrix {
    public static void setZero(int[][] a){
        int col0 = 1, r = a.length, c = a[0].length;

        for(int i = 0;i<r;i++){
            if(a[i][0] == 0) col0 = 0;

            for(int j = 0;j<c;j++){
                if(a[i][j] == 0)
                    a[i][0] = a[0][j] = 0;
            }
        }

        for(int i = 0;i<r;i++){
            for(int j = a.length-1;j>=0;j--){
                if(a[i][0] == 0 || a[0][j] == 0)
                    a[i][j] = 0;
            }
            if(col0 == 0) a[i][0] = 0;
        }
    }
}
