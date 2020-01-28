import java.util.HashMap;

public class SongTime {

	public int numPairsDivisibleBy60(int[] time) {

		int count = 0;
		int countOne = 0;
		int countTwo = 0;

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < time.length; i++) {
			if ((time[i] % 60) == 0) {
				countOne++;
			} else if ((time[i] % 30) == 0) {
				countTwo++;
			} else{
				if (map.containsKey((time[i] % 60))) {
					map.put((time[i] % 60),map.get((time[i] % 60))+1);
				}
				else {
					map.put((time[i] % 60), 1);
				}
			}

		}
		for(int i=1;i<30;i++) {
			if(map.containsKey(i)&& map.containsKey(60-i)) {
				count+=map.get(i)*map.get(60-i);
			}
		}
		count += (countOne * (countOne - 1)) / 2;
		count += (countTwo * (countTwo - 1)) / 2;
		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 174, 188, 377, 437, 54, 498, 455, 239, 183, 347, 59, 199, 52, 488, 147, 82 };

		System.out.println(new SongTime().numPairsDivisibleBy60(input));
	}

}
