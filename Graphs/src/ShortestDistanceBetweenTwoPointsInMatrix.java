import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceBetweenTwoPointsInMatrix {
    static class QItem {
        int row;
        int col;
        int dist;
        public QItem(int row, int col, int dist)
        {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    private static int minDistance(char[][] grid) {
        QItem s = new QItem(0, 0, 0);

        firstLoop:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] == 's') {
                    s.row = i;
                    s.col = j;
                    break firstLoop;
                }
            }
        }

        Queue<QItem> q = new LinkedList<>();
        q.add(new QItem(s.row, s.col, 0));

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[s.row][s.col] = true;

        while (!q.isEmpty()){
            QItem temp = q.remove();
            int r = temp.row;
            int c = temp.col;
            int d = temp.dist;

            if(grid[r][c] == 'd')
                return d;

            if(isValid(r - 1, c, grid, visited)){
                q.add(new QItem(r - 1, c, d + 1));
                visited[r][c] = true;
            }

            if(isValid(r, c + 1, grid, visited)){
                q.add(new QItem(r, c + 1, d + 1));
                visited[r][c] = true;
            }

            if(isValid(r + 1, c, grid, visited)){
                q.add(new QItem(r + 1, c, d + 1));
                visited[r][c] = true;
            }

            if(isValid(r, c - 1, grid, visited)){
                q.add(new QItem(r, c - 1, d + 1));
                visited[r][c] = true;
            }
        }
        return -1;
    }

    public static boolean isValid(int row, int col, char[][] grid, boolean[][] visited){
        if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] != '0' && !visited[row][col])
            return true;
        return false;
    }
    public static void main(String[] args) {
        char[][] grid = { { '0', '*', '0', 's' },
                { '*', '0', '*', '*' },
                { '0', '*', '*', '*' },
                { 'd', '*', '*', '*' } };

        System.out.println(minDistance(grid));
    }
}
