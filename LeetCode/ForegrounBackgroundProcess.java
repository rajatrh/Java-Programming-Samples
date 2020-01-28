import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ForegrounBackgroundProcess {

	List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList,
			List<List<Integer>> backgroungAppList) {

		Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(1) - o2.get(1);
			}
		};

		Collections.sort(foregroundAppList, comparator);
		Collections.sort(backgroungAppList, comparator);

		List<List<Integer>> result = new ArrayList<>();

		int i = 0;
		int j = backgroungAppList.size() - 1;
		int maxCap = Integer.MIN_VALUE;

		while (i < foregroundAppList.size() && j >= 0) {
			int totalCurrentCapacity=foregroundAppList.get(i).get(1)+backgroungAppList.get(j).get(1);
			if (totalCurrentCapacity > deviceCapacity) {
				j--;
			} else {
				List<Integer> temp = new ArrayList<>();
				temp.add(foregroundAppList.get(i).get(0));
				temp.add(backgroungAppList.get(j).get(0));
				if (totalCurrentCapacity > maxCap) {
					maxCap = totalCurrentCapacity;
					result = new ArrayList<>();
					result.add(temp);

				} else if (totalCurrentCapacity == maxCap) {
					result.add(temp);
				}
				i++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int deviceCapacity = 7;
		 * 
		 * List<List<Integer>> foregroundAppList = new ArrayList<>(); List<Integer> temp
		 * = new ArrayList<>(); temp.add(1); temp.add(2); foregroundAppList.add(temp);
		 * temp = new ArrayList<>(); temp.add(2); temp.add(4);
		 * foregroundAppList.add(temp); temp = new ArrayList<>(); temp.add(3);
		 * temp.add(6); foregroundAppList.add(temp);
		 * 
		 * List<List<Integer>> backgroungAppList = new ArrayList<>(); temp = new
		 * ArrayList<>(); temp.add(1); temp.add(2); backgroungAppList.add(temp);
		 */

		int deviceCapacity = 10;

		List<List<Integer>> foregroundAppList = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		temp.add(3);
		foregroundAppList.add(temp);
		temp = new ArrayList<>();
		temp.add(2);
		temp.add(5);
		foregroundAppList.add(temp);
		temp = new ArrayList<>();
		temp.add(3);
		temp.add(7);
		foregroundAppList.add(temp);
		temp = new ArrayList<>();
		temp.add(4);
		temp.add(10);
		foregroundAppList.add(temp);

		List<List<Integer>> backgroungAppList = new ArrayList<>();
		temp = new ArrayList<>();
		temp.add(1);
		temp.add(2);
		backgroungAppList.add(temp);
		temp = new ArrayList<>();
		temp.add(2);
		temp.add(3);
		backgroungAppList.add(temp);
		temp = new ArrayList<>();
		temp.add(3);
		temp.add(4);
		backgroungAppList.add(temp);
		temp = new ArrayList<>();
		temp.add(4);
		temp.add(5);
		backgroungAppList.add(temp);

		System.out.println(new ForegrounBackgroundProcess().optimalUtilization(deviceCapacity, foregroundAppList,
				backgroungAppList));

	}

}
