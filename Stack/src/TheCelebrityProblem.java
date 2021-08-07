/*
* A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people,
* find if there is a celebrity in the party or not. A square NxN matrix M[][] is used to represent people at the party such
* that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
* https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1#
* */


import java.util.Stack;

public class TheCelebrityProblem { //Space O(n) time O(n)
    int celebrity(int mat[][], int n)
    {
        // code here
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            s.push(i);
        }

        while(s.size() > 1){
            int i = s.pop();
            int j = s.pop();

            if(mat[i][j] == 1) // if i knows j that means i can never be celebrity coz celebrity can never know someone, so j can be celebrity
                s.push(j);
            else               // if i does not know j, then j can't be celeb coz celeb is known by everyone, so i can be celeb
                s.push(i);

        }
        if(s.isEmpty())
            return -1;
        int pot = s.pop();
        for(int i = 0;i<mat.length;i++){ //rerun to check if pot is actually the celeb
            if(i != pot){
                if(mat[i][pot] == 0 || mat[pot][i] == 1)
                    return -1;
            }
        }

        return pot;
    }
    int celebrityLinear(int mat[][], int n){ //Space O(1) Time O(n)
        int i = 0, j = n-1;
        while(i <= j){
            if(mat[i][j] == 1)
                i++;
            else
                j--;
        }
        int pot = i;
        for(i = 0;i<n;i++){
            if(i != pot && (mat[i][pot] == 0 || mat[pot][i] == 1))
                return -1;
        }
        return pot;
    }

}
