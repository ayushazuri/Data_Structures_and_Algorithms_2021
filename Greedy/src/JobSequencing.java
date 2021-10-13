//https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
/*Given a set of N jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time.
We earn the profit if and only if the job is completed by its deadline.
The task is to find the number of jobs done and the maximum profit.*/
import java.util.Arrays;

public class JobSequencing {
    class Job{
        int id, profit, deadline;
        Job(int _id,int _profit, int _deadline){
            id = _id;
            profit = _profit;
            deadline = _deadline;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxd = 0;
        for(Job i: arr){
            if (i.deadline > maxd)
                maxd = i.deadline;
        }

        int[] job = new int[maxd+1];

        Arrays.fill(job, -1);
        int count = 0, maxp = 0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j > 0; j--){
                if(job[j] == -1){
                    job[j] = i;
                    count++;
                    maxp += arr[i].profit;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = maxp;
        return ans;
    }
}
