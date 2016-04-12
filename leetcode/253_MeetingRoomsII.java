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
     * Construct a priority queue to store the available time of each room, order by the finish time
     * Order the interval array on the start time.
     * Every time pull out a interval, check if existing rooms are available.
     *      If current interval start time is smaller than the earlist finished time in the pq, then add it to a new room
     *      If current interval start time is after the earliest finished time in the pq, extend the finish time to the earlist finish time
     * Output the size of the priority queue
     * */
    public int minMeetingRooms(Interval[] intervals) {
        //ArrayList<Integer> rooms = new ArrayList<Integer>();
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval inter1, Interval inter2){
                return inter1.start - inter2.start;
                }
            });
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(intervals[0].end);
        for(int i = 1; i<intervals.length; i++){
            int earlist = queue.poll();
            if(intervals[i].start>=earlist){
                earlist = intervals[i].end;
            }
            else{
                queue.offer(intervals[i].end);
            }
            queue.offer(earlist);
        }
        return queue.size();
    }
}