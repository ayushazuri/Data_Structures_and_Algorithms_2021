//https://www.youtube.com/watch?v=Y72QeX0Efxw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=13&ab_channel=takeUforward
// Rotate by 90 deg. Transform to transpose matrix, then reverse each row.

public class RotateImage {
    public static void rotate(int[][] a){
        int r = a.length;
        int c = a[0].length;
        for(int i = 0;i<r;i++){
            for(int j = i;j<c;j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        for(int i = 0;i<r;i++){
            for(int j = 0;j<c/2;j++){
                int temp = a[i][j];
                a[i][j] = a[i][r - 1 - j];
                a[i][r - 1 - j] = temp;
            }
        }
    }
}
