/**
 * Created by viran on 11-06-2017.
 */
import java.util.*;
public class Greedy {


      //Definition for an interval.
      public class Interval {
          int start;
          int end;Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

 class Compare implements Comparator<Interval>
 {
    public int compare(Interval i1, Interval i2)
    {
        return i1.end-i2.end;
    }
 }
        public int eraseOverlapIntervals(Interval[] intervals) {
            if(intervals == null || intervals.length == 0 )
                return 0;

            // sort by finishing time way we do in task scheduling
            //mArray.sort(intervals, new Compare());
            int possible = 1;
            int value = intervals[0].end;
           for(int i=1;i<intervals.length;i++)
            {
                if(intervals[i].start<=value )
                    continue;
                else
                {
                    value=intervals[i].end;
                    possible++;
                }
            }
            return intervals.length-possible;
        }

    }
