package h1.t5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2018/1/12].
 */
public class MergeIntervals {

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", start, end);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        int[] startArr = new int[intervals.size()];
        int[] endArr = new int[intervals.size()];
        Iterator<Interval> iter = intervals.iterator();
        int i = 0;
        while (iter.hasNext()) {
            Interval cur = iter.next();
            startArr[i] = cur.start;
            endArr[i] = cur.end;
            i++;
        }
        return checkArr(startArr, endArr);
    }

    private List<Interval> checkArr(int[] startArr, int[] endArr) {
        if(startArr.length == 0){
            return new ArrayList<>();
        }
        List<Interval> intervals = new ArrayList<>();
        int start = startArr[0];
        int end = endArr[0];
        for (int i = 1; i < startArr.length; i++) {
            if (startArr[i] <= end) {
                if(endArr[i] > end) {
                    end = endArr[i];
                }
            } else {
                intervals.add(new Interval(start, end));
                start = startArr[i];
                end = endArr[i];
            }
        }
        intervals.add(new Interval(start, end));
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1, 3),
                new Interval(0, 6),
                new Interval(8, 10),
                new Interval(9, 11),
                new Interval(12, 13),
                new Interval(15, 18));
        System.out.println(new MergeIntervals().merge(intervals));
    }
}
