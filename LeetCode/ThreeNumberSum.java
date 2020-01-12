import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ThreeNumberSum {
    public static void main(String args[]) {
        Program program = new Program();
        int array[] = {12, 3, 1, 2, -6, 5, -8, 6};
        ArrayList<Integer[]> list = program.threeNumberSum(array, 0);
        for(Integer[] l : list) {
            System.out.println("WTF : " + Arrays.toString(l));
        }
    }
}

class Program {
    public ArrayList<Integer[]> threeNumberSum(int[] array, int targetSum) {
        ArrayList<Integer[]> result = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i =0; i< array.length; i++) {
            hm.put(i, array[i]);
        }
        for (int i =0; i< array.length; i++) {
            for (int j =0; j< array.length; j++) {
                if (i != j) {
                    int diff = targetSum - (array[i] + array[j]);
                    if (hm.containsValue(diff)) {
                        result.add(new Integer[]{array[i], array[j], diff});
                    }
                }
            }
        }
        
        return result;
    }
  }