import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonBuilder {

	public int minimumTime(int numOfParts, List<Integer> parts) {
		int minimunT = 0;
		int total = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(numOfParts);
		for (int i : parts) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			int firstElement = queue.poll();
			int secondElement = queue.poll();
			minimunT = firstElement + secondElement;
			total += minimunT;
			queue.add(minimunT);
		}

		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOfParts = 4;
		List<Integer> parts = new ArrayList<>();
		parts.add(8);
		parts.add(4);
		parts.add(6);
		parts.add(12);
		System.out.println(new AmazonBuilder().minimumTime(numOfParts, parts));

	}

}
