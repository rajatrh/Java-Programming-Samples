import java.util.ArrayList;
import java.util.HashMap;

public class SongProblem {
	public ArrayList<Integer> IDsofSongs(int rideDuration, ArrayList<Integer> songDurations) {
		int songTotal = rideDuration - 30;
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxValue = Integer.MIN_VALUE;
		ArrayList<Integer> songPair = new ArrayList<>();
		for (int i = 0; i < songDurations.size(); i++) {
			if (map.containsKey(songTotal - songDurations.get(i))) {
				if (Math.max(songDurations.get(i), songTotal - songDurations.get(i)) > maxValue) {
					maxValue = Math.max(songDurations.get(i), songTotal - songDurations.get(i));
					songPair = new ArrayList<>();
					songPair.add(map.get(songTotal - songDurations.get(i)));
					songPair.add(i);
				}
			} else {
				map.put(songDurations.get(i), i);
			}
		}
		return songPair;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * int rideDuration = 110; ArrayList<Integer> songDurations = new ArrayList<>();
		 * songDurations.add(20); songDurations.add(70); songDurations.add(90);
		 * songDurations.add(30); songDurations.add(60); songDurations.add(110);
		 */

		int rideDuration = 250;
		ArrayList<Integer> songDurations = new ArrayList<>();
		songDurations.add(100);
		songDurations.add(180);
		songDurations.add(40);
		songDurations.add(120);
		songDurations.add(10);

		System.out.println(new SongProblem().IDsofSongs(rideDuration, songDurations));

	}

}
