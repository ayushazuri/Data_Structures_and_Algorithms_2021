/*There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
        You have a car with an unlimited gas tank and it costs cost[i] of gas
        to travel from the ith station to its next (i + 1)th station.
        You begin the journey with an empty tank at one of the gas stations.

        Given two integer arrays gas and cost, return the starting gas station's
        index if you can travel around the circuit once in the clockwise direction,
        otherwise return -1. If there exists a solution, it is guaranteed to be unique*/
//https://leetcode.com/problems/gas-station/


public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(n == 1){
            if(gas[0]-cost[0] >= 0)
                return 0;
            else
                return -1;
        }
        int start = 0, end = 1;
        int curr = gas[start] - cost[start];

        while(start != end || curr < 0){

            while(curr < 0 && start != end){
                curr -= gas[start] - cost[start];
                start = (start+1)%n;

                if(start == 0)
                    return -1;
            }

            curr += gas[end] - cost[end];
            end = (end+1)%n;
        }
        return start;
    }

}
