/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    /**
     * check if every meeting starts after previous one ends
     * */
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval inter1, Interval inter2){
                return inter1.end - inter2.end;
                }
            });
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i].start<intervals[i-1].end) return false;
        }
        return true;
    }
}