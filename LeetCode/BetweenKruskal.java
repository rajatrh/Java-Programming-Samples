import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
	int source;
	int destination;
	int weight;

	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}

public class BetweenKruskal {

	public int find(int[] parent, int vertex) {

		if (parent[vertex] != vertex)
			return find(parent, parent[vertex]);
		return vertex;
	}

	public void union(int[] parent, int x, int y) {
		int x_set_parent = find(parent, x);
		int y_set_parent = find(parent, y);
		parent[y_set_parent] = x_set_parent;
	}

	public int minimumCostincurred(int numTotalEdgeNodes, int numTotalAvailbaleNetworkRoutes,
			List<List<Integer>> networkRoutesAvailable, int newNetworkroutesConstruct,
			List<List<Integer>> costNewNetworkRoutes) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(costNewNetworkRoutes.size(),
				Comparator.comparingInt(o -> o.weight));
		int returnCost = 0;
		for (int i = 0; i < costNewNetworkRoutes.size(); i++) {
			List<Integer> curr = costNewNetworkRoutes.get(i);
			pq.add(new Edge(curr.get(0), curr.get(1), curr.get(2)));
		}

		int[] parent = new int[numTotalEdgeNodes];

		for (int i = 0; i < numTotalEdgeNodes; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < networkRoutesAvailable.size(); i++) {
			List<Integer> temp = networkRoutesAvailable.get(i);
			parent[temp.get(1) - 1] = temp.get(0) - 1;
		}
		int index = 0;
		while (index < costNewNetworkRoutes.size() && (!pq.isEmpty())) {
			Edge edge = pq.remove();
			
			int x_set = find(parent, edge.source - 1);
			int y_set = find(parent, edge.destination - 1);

			if (x_set == y_set) {
				
			} else {
				
				returnCost += edge.weight;
				index++;
				union(parent, x_set, y_set);
			}
		}

		return returnCost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numTotalEdgeNodes = 6;
		int numTotalAvailbaleNetworkRoutes = 4;
		List<List<Integer>> networkRoutesAvailable = new ArrayList<>();
		int newNetworkroutesConstruct = 2;
		List<List<Integer>> costNewNetworkRoutes = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		temp.add(4);
		networkRoutesAvailable.add(temp);
		
		temp = new ArrayList<>();
		temp.add(1);
		temp.add(2);
		networkRoutesAvailable.add(temp);

		temp = new ArrayList<>();
		temp.add(2);
		temp.add(3);
		networkRoutesAvailable.add(temp);

		temp = new ArrayList<>();
		temp.add(4);
		temp.add(5);
		networkRoutesAvailable.add(temp);
		temp = new ArrayList<>();
		temp.add(3);
		temp.add(5);
		networkRoutesAvailable.add(temp);

		temp = new ArrayList<>();
		temp.add(1);
		temp.add(6);
		temp.add(410);
		costNewNetworkRoutes.add(temp);

		temp = new ArrayList<>();
		temp.add(2);
		temp.add(4);
		temp.add(800);
		costNewNetworkRoutes.add(temp);

		

		System.out.println(new BetweenKruskal().minimumCostincurred(numTotalEdgeNodes, numTotalAvailbaleNetworkRoutes,
				networkRoutesAvailable, newNetworkroutesConstruct, costNewNetworkRoutes));

	}

}
