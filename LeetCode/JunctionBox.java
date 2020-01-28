import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JunctionBox {

	
	public List<String> orderedJunctionBoxes(int numberofBoxes, List<String> boxList){
		List<String> returnList=new ArrayList<>();
		PriorityQueue<String> pq = new PriorityQueue<>(numberofBoxes, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.substring(o1.indexOf(" ")+1).compareTo(o2.substring(o2.indexOf(" ")+1))==0) {
					return o1.substring(0,o1.indexOf(" ")).compareTo(o2.substring(0,o2.indexOf(" ")));
				}
				else {
					return o1.substring(o1.indexOf(" ")+1).compareTo(o2.substring(o2.indexOf(" ")+1));
				}
			}
		});
		
		List<String> newVersion=new ArrayList<>();
		
		
		
		for(String str:boxList) {
			if(str.substring(str.indexOf(" ")+1).replaceAll(" ", "").matches("[0-9]+")) {
				newVersion.add(str);
			}
			else {
				pq.add(str);
			}
		}
		while(!pq.isEmpty()) {
			returnList.add(pq.poll());
		}
		returnList.addAll(newVersion);
		
		return returnList;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int numberofBoxes=6;
		List<String> boxList=new ArrayList<>();
		boxList.add("ykc 82 0");
		boxList.add("eo first qpx");
		boxList.add("09z cat hamster");
		boxList.add("06f 12 25 6");
		boxList.add("az0 first qpx");
		boxList.add("236 cat dog rabbit snake");*/
		
		int numberofBoxes=6;
		List<String> boxList=new ArrayList<>();
		boxList.add("t2 13 121 98");
		boxList.add("r1 box ape bit");
		boxList.add("b4 xi mi nu");
		boxList.add("br8 eat nim did");
		boxList.add("w1 has uni gry");
		boxList.add("f3 52 54 21");
		
		System.out.println(new JunctionBox().orderedJunctionBoxes(numberofBoxes, boxList));
		

	}

}
