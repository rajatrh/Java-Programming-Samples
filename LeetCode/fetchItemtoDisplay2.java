
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class fetchItemtoDisplay2 {

	public List<String> fetchItemTodisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage,
			int pageNumber) {

		PriorityQueue<List<String>> pq = new PriorityQueue<>(items.size(),(Comparator<List<String>>) (o1, o2) -> {
			if (sortOrder == 0)
				return o1.get(sortParameter).compareTo(o2.get(sortParameter));
			else {
				return o2.get(sortParameter).compareTo(o1.get(sortParameter));
			}
		});
		for (List<String> itemStr : items) {
			pq.add(itemStr);
		}
		for (int i = 0; i < pageNumber * itemPerPage; i++) {
			pq.poll();
		}
		List<String> returnString = new ArrayList<>();
		for (int j = 0; j < itemPerPage; j++) {
			returnString.add(pq.poll().get(0));
		}
		return returnString;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * List<List<String>> items = new ArrayList<>(); int sortParameter = 2; int
		 * sortOrder = 1; int itemPerPage = 2; int pageNumber = 0;
		 * 
		 * List<String> item = new ArrayList<>(); item.add("owjevtkuyv");
		 * item.add("58584272"); item.add("62930912"); items.add(item);
		 * 
		 * item = new ArrayList<>(); item.add("rpaqgbjxik"); item.add("9425650");
		 * item.add("96088250"); items.add(item);
		 * 
		 * item = new ArrayList<>(); item.add("dfbkasyqon"); item.add("37469674");
		 * item.add("46363902"); items.add(item);
		 * 
		 * item = new ArrayList<>(); item.add("vjrriadfxe"); item.add("18666489");
		 * item.add("88046739"); items.add(item);
		 */

		List<List<String>> items = new ArrayList<>();
		int sortParameter = 0;
		int sortOrder = 0;
		int itemPerPage = 1;
		int pageNumber = 0;

		List<String> item = new ArrayList<>();
		item.add("p1");
		item.add("1");
		item.add("2");
		items.add(item);

		item = new ArrayList<>();
		item.add("p2");
		item.add("2");
		item.add("1");
		items.add(item);

		System.out.println(
				new fetchItemtoDisplay2().fetchItemTodisplay(items, sortParameter, sortOrder, itemPerPage, pageNumber));

	}

}
