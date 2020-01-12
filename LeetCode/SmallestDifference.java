import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SmallestDifference {
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
    public int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[2];
        return result;
    }
  }