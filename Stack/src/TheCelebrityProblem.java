/*
* A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people,
* find if there is a celebrity in the party or not. A square NxN matrix M[][] is used to represent people at the party such
* that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
* https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1#
* */


import java.util.Stack;

public class TheCelebrityProblem {
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

            if(mat[i][j] == 1)
                s.push(j);
            else
                s.push(i);

        }
        if(s.isEmpty())
            return -1;
        int pot = s.pop();
        for(int i = 0;i<mat.length;i++){
            if(i != pot){
                if(mat[i][pot] == 0 || mat[pot][i] == 1)
                    return -1;
            }
        }

        return pot;
    }
}
