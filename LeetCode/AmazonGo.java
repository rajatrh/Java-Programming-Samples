import java.util.ArrayList;
import java.util.List;

public class AmazonGo {
	
	public List<Integer> lengthSubsequenceShoppers(List<Character> inputList){
		List<Integer> returnist=new ArrayList<>();
		int i=1,j=0;
		for(;i<inputList.size();) {
			List<Character> firstList=inputList.subList(j, i);
			List<Character> secondtList=inputList.subList(i, inputList.size());
			int k=0;
			while(k<firstList.size()){
				if(secondtList.contains(firstList.get(k))){
					int l=0;
					while(l<secondtList.size()) {
						if(secondtList.get(l).equals(firstList.get(k))) {
							returnist.add(firstList.size()+l+1);
							j=firstList.size()+l+1;
							i=firstList.size()+l+2;
							break;
						}
						l++;
					}
				}
				else
				{
				k++;
				}
			}
				
				
			
			
			
		}
		returnist.add(returnist.size()-1-j);
		
		return returnist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> input=new ArrayList<>();
		input.add('a');
		input.add('b');
		input.add('c');
		input.add('a');
		input.add('f');
		input.add('g');
		input.add('f');
		input.add('k');
		
		System.out.println(new AmazonGo().lengthSubsequenceShoppers(input));

	}

}
