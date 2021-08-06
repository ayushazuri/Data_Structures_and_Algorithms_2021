/*
* There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i])
*  where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only
* one meeting can be held in the meeting room at a particular time?
*
* https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class nMeetingInRoom {
    static class meeting{
        int start;
        int end;
        int pos;
        meeting(int s, int e, int p){
            start = s;
            end = e;
            pos = p;
        }
    }

    static class meetSort implements Comparator<meeting> {
        @Override
        public int compare(meeting o1, meeting o2){
            if(o1.end < o2.end)
                return -1;
            else if(o1.end > o2.end)
                return 1;
            else if(o1.pos < o2.pos)
                return -1;
            else
                return 1;
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<meeting> al = new ArrayList<>();
        for(int i=0;i<start.length;i++)
            al.add(new meeting(start[i], end[i], i+1));

        meetSort ms = new meetSort();
        Collections.sort(al, ms);
        int limit = al.get(0).end;
        int count = 1;
        for(int i = 1;i<al.size();i++){
            if(al.get(i).start > limit){
                limit = al.get(i).end;
                count++;
            }
        }
        return count;
    }
}
