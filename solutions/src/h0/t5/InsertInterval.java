package h0.t5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2018/3/12].
 */
public class InsertInterval {

    private static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + this.start + ", " + this.end + "]";
        }
    }

    /**
     * 思路：
     * 1. 放左侧内容
     * 2. 放覆盖部分
     * 3. 放右侧内容
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            // we could mutate newInterval here also
            newInterval = new Interval(
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        // add the union of intervals we got
        result.add(newInterval);
        // add all the rest
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }


    /**
     * 思路：
     * 遍历当前序列，将每个元素与新增元素进行对比，按照指定规则放入结果集合中。
     */
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        if (newInterval == null) {
//            return intervals;
//        }
//        List<Interval> result = new ArrayList<>();
//        if (intervals == null) {
//            result.add(newInterval);
//            return result;
//        }
//        int ns = newInterval.start;
//        int ne = newInterval.end;
//        for (Interval interval : intervals) {
//            int cs = interval.start;
//            int ce = interval.end;
//            if (ns <= cs) {
//                if (ne <= ce) {
//                    if (ne < cs) {
//                        // 新增内容在最左侧
//                        result.add(new Interval(ns, ne));
//                        ns = cs;
//                        ne = ce;
//                    } else {
//                        // 新增内容与原有内容左侧部分覆盖
//                        ne = ce;
//                    }
//                } else {
//                    // 覆盖情况，不进行操作
//                }
//            } else {
//                if (ns <= ce) {
//                    if (ne <= ce) {
//                        // 新增内容被原有内容覆盖
//                        ns = cs;
//                        ne = ce;
//                    } else {
//                        // 新增内容与原有内容右侧部分覆盖
//                        ns = cs;
//                    }
//                } else {
//                    // 新增内容在右侧
//                    result.add(new Interval(cs, ce));
//                }
//            }
//        }
//        result.add(new Interval(ns, ne));
//        return result;
//    }
    public static List<Interval> testCase1() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(6, 9));
        return list;
    }

    public static List<Interval> testCase2() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 2));
        list.add(new Interval(3, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 10));
        list.add(new Interval(12, 16));
        return list;
    }

    public static void main(String[] args) {
        List<Interval> list = testCase2();
        System.out.println(new InsertInterval().insert(list, new Interval(4, 9)));
    }
}
