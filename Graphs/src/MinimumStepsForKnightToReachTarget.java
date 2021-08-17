import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//Not working properly. Visit https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
public class MinimumStepsForKnightToReachTarget {
    public static void main(String[] args) {
        int N = 30;
        int[] knightPos = { 1, 1 };
        int[] targetPos = { 30, 30 };
        System.out.println(
                minStepToReachTarget(
                        knightPos, targetPos, N));
    }
    static class Cell{
        int x, y;
        int dist;
        Cell(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = y;
        }
    }

    static boolean isValid(int x, int y, int N){
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    private static int minStepToReachTarget(int[] knightPos, int[] targetPos, int n) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(knightPos[0], knightPos[1], 0));

        boolean[][] vis = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                vis[i][j] = false;
            }
        }
        vis[knightPos[0]][knightPos[1]] = true;

        int[] row = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] col = { -1, -2, -2, -1, 1, 2, 2, 1 };
        Cell curr;
        while(!queue.isEmpty()){
            curr = queue.peek();
            System.out.println(curr.x + " " + curr.y + "  " + curr.dist);
            queue.poll();

            if(curr.x == targetPos[0] && curr.y == targetPos[1]){
                return curr.dist;
            }

            for(int i = 0; i < 8; i++){
                int r = curr.x + row[i];
                int c = curr.y + col[i];
                if(isValid(r, c, n) && !vis[r][c]){
                    vis[r][c] = true;
                    queue.add(new Cell(r, c, curr.dist + 1));
                }
            }
        }
        return -1;
    }
}
