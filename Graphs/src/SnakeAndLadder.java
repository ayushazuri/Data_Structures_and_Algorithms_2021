import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
    static class QEntry{
        int ver;
        int dist;
    }

    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));
    }

    private static int getMinDiceThrows(int[] moves, int n) {
        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        Queue<QEntry> q = new LinkedList<>();
        QEntry qe = new QEntry();
        qe.ver = 0;
        qe.dist = 0;
        visited[0] = 1;
        q.add(qe);
        while(!q.isEmpty()){
            qe = q.poll();
            int v = qe.ver;
            if(v == n-1)
                break;

            for(int j=v+1; j<(v+6) && j < n; j++){
                if(visited[j] == 0 ){
                    visited[j] = 1;
                    QEntry newEntry = new QEntry();
                    newEntry.dist = qe.dist+1;
                    if(moves[j] != -1)
                        newEntry.ver = moves[j];
                    else
                        newEntry.ver = j;

                    q.add(newEntry);
                }

            }
        }
        return qe.dist;
    }
}
