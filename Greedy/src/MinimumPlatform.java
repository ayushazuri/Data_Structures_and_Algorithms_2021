/*
* Given arrival and departure times of all trains that reach a railway station.
* Find the minimum number of platforms required for the railway station so that no train is kept waiting.
* Consider that all the trains arrive on the same day and leave on the same day.
* Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other.
* At any given instance of time, same platform can not be used for both departure of a train and arrival of another train.
* In such cases, we need different platforms.
*  https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
* */

import java.util.Arrays;

public class MinimumPlatform {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat = 1, maxPlat = 0;
        int i = 1; int j = 0;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                plat++;
                i++;
            }else if(arr[i] > dep[j]){
                plat--;
                j++;
            }

            maxPlat = Math.max(plat, maxPlat);
        }

        return maxPlat;

    }
}
