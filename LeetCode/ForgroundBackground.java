import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForgroundBackground {

    public static void main(String[] args) {


        List<List<Integer>> foreground = new ArrayList<>();
        List<List<Integer>> background = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        foreground.add(temp);

        temp = new ArrayList<>();
        temp.add(2);
        temp.add(4);
        foreground.add(temp);

        temp = new ArrayList<>();
        temp.add(3);
        temp.add(6);
        foreground.add(temp);

        temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        background.add(temp);

//        List<Integer> temp = new ArrayList<>();
//        temp.add(1);
//        temp.add(3);
//        foreground.add(temp);
//
//        temp = new ArrayList<>();
//        temp.add(2);
//        temp.add(5);
//        foreground.add(temp);
//
//        temp = new ArrayList<>();
//        temp.add(3);
//        temp.add(7);
//        foreground.add(temp);
//
//
//        temp = new ArrayList<>();
//        temp.add(4);
//        temp.add(10);
//        foreground.add(temp);
//
//
//        temp = new ArrayList<>();
//        temp.add(1);
//        temp.add(2);
//        background.add(temp);
//
//        temp = new ArrayList<>();
//        temp.add(2);
//        temp.add(3);
//        background.add(temp);
//
//        temp = new ArrayList<>();
//        temp.add(3);
//        temp.add(4);
//        background.add(temp);
//
//        temp = new ArrayList<>();
//        temp.add(4);
//        temp.add(5);
//        background.add(temp);

        
        List<List<Integer>> list = new ForgroundBackground().optimalUtilization(7, foreground, background);



        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }

    }

    List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foreground, List<List<Integer>> background) {
        Map<Integer, List<List<Integer>>> hmap = new HashMap<>();

        int maxSum = 0;

        for(int i=0;i<foreground.size();i++) {
            for(int j=0;j<background.size();j++) {

                int sum = foreground.get(i).get(1) + background.get(j).get(1);

                if(deviceCapacity>=sum && sum>=maxSum) {
                    maxSum = sum;
                    List<Integer> newList = new ArrayList<>();
                    if(hmap.containsKey(sum)) {

                        newList.add(foreground.get(i).get(0));
                        newList.add(background.get(j).get(0));

                        hmap.get(sum).add(newList);
                    } else {
                        newList.add(foreground.get(i).get(0));
                        newList.add(background.get(j).get(0));

                        List<List<Integer>> l = new ArrayList<>();
                        l.add(newList);
                        hmap.put(sum, l);
                    }

                }

            }
        }
        return hmap.get(maxSum);

    }
}
