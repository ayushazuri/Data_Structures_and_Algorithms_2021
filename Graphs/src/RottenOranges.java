import java.util.LinkedList;
import java.util.Queue;
public class RottenOranges {
    static int R = 3;
    static int C = 5;
    public static void main(String[] args)
    {
        int v[][] = { { 2, 1, 0, 2, 1 },
                { 1, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 } };
        System.out.println("Max time incurred: " +
                rotOranges(v));
        System.out.println("Max time incurred: " +
                rotOrangesBFS(v));
    }
    static class QElem{
        int x;
        int y;
        QElem(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean isDelim(QElem temp){
        return (temp.x == -1 && temp.y == -1);
    }

    static boolean isValid(int i, int j){

        return (i >= 0 && j >= 0 && i < R && j < C);
    }
    static boolean checkAll(int arr[][])
    {
        for (int i=0; i<R; i++)
            for (int j=0; j<C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }
    static int rotOrangesBFS(int[][] a){ //Not giving correct answer, refer GFG
        Queue<QElem> queue = new LinkedList<>();
        int r = a.length, c = a[0].length;
        for (int i=0; i < R; i++)
            for (int j=0; j < C; j++)
                if (a[i][j] == 2)
                    queue.add(new QElem(i,j));

        int[] row = {1, 0, -1, 0};
        int[] col = {0, 1, 0, -1};
        queue.add(new QElem(-1,-1));
        QElem temp;
        int ans = 0;
        while(!queue.isEmpty()){
            boolean flag = false;

            while(!isDelim(queue.peek())){
                temp = queue.peek();
                for(int i=0;i<4;i++){
                    if(isValid(temp.x+row[i], temp.y+col[i]) && a[temp.x+row[i]][temp.y+col[i]] ==1){
                        System.out.println(12);
                        if(!flag) {
                            ans++;
                            flag = true;
                        }
                        a[temp.x+row[i]][temp.y+col[i]] = 2;
                        queue.add(new QElem(temp.x+row[i],temp.y+col[i]));
                    }
                }
                queue.remove();
            }
            queue.remove();
            if(!queue.isEmpty()){
                queue.add(new QElem(-1,-1));
            }
        }
        if(checkAll(a))
            return -1;
        return ans;
    }

    /*-----------------------------------Naive Solution-----------------------------------------*/
    static boolean issafe(int i, int j) {
        if (i >= 0 && i < R && j >= 0 && j < C)
            return true;
        return false;
    }

    static int rotOranges(int v[][]) //O((R*C)*(R*C))
    {
        boolean changed = false;
        int no = 2;

        while (true) {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if (v[i][j] == no) {
                        if (issafe(i + 1, j) && v[i + 1][j] == 1) {
                            v[i + 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j + 1) && v[i][j + 1] == 1) {
                            v[i][j + 1] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i - 1, j) && v[i - 1][j] == 1){
                            v[i - 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j - 1) && v[i][j - 1] == 1){
                            v[i][j - 1] = v[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }
            if (!changed)
                break;

            changed = false;
            no++;
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (v[i][j] == 1)
                    return -1;
            }
        }
        return no - 2;
    }
}
