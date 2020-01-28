import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class boxCrate {
	
	
	
	public List<List<Integer>> closestLocations(int totalCrates,List<List<Integer>> allLocation, int truchCapacity){
		
		List<List<Integer>> returnList=new ArrayList<>();
		if(totalCrates<1) return returnList;
		
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>(totalCrates,new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				return (int) ((Math.pow(o1.get(0), 2)+Math.pow(o1.get(1), 2))-(Math.pow(o2.get(0), 2)+Math.pow(o2.get(1), 2)));
			}
			
		});
		for(List<Integer> x:allLocation) {
			
			pq.add(x);
		}
		
		for(int i=0;i<truchCapacity && !pq.isEmpty();i++) {
			returnList.add(pq.poll());
			
		}
		return returnList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalCrates=3;
		List<List<Integer>> allLocation=new ArrayList<>();
		List<Integer> point=new ArrayList<>();
		point.add(1);
		point.add(2);
		allLocation.add(point);
		point=new ArrayList<>();
		point.add(3);
		point.add(4);
		allLocation.add(point);
		point=new ArrayList<>();
		point.add(1);
		point.add(-1);
		allLocation.add(point);
		int truchCapacity=2;
		System.out.println(new boxCrate().closestLocations(totalCrates, allLocation, truchCapacity));
		

	}

}
