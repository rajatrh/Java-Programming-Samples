import java.util.*;

class Interval {
    int begin;
    int end;
    
    Interval(int b, int e) {
        begin=b;
        end=e;
    }
    
    public int[] toArray() {
        return new int[]{begin, end};
    }
    
    public String toString() {
        return "[" + begin + "," + end + "]";
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
        return a.begin - b.begin;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<Interval> inters = new ArrayList<Interval>();
        for (int[] i: intervals) {
            inters.add(new Interval(i[0], i[1]));
        }
        
        Collections.sort(inters, new IntervalComparator());
        
        // for (Interval i: inters) {
        //     System.out.println(i);
        // }
        
        LinkedList<Interval> mergedList = new LinkedList<>();
        
        for (Interval i: inters) {
            if(mergedList.isEmpty() || mergedList.getLast().end < i.begin) {
                mergedList.add(i);
            } else {
                mergedList.getLast().end = Math.max(mergedList.getLast().end, i.end);
            }
        }
        
        int[][] res = new int[mergedList.size()][2];
        int z=0;
        for (Interval i: mergedList) {
            //System.out.println(i);
            res[z] = i.toArray();
            z++;
        }
        
        return res;
    }
}