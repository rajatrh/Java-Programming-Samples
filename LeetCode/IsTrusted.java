package celo;

import java.util.HashSet;

public class IsTrusted {
	public HashSet<Integer> isVisted = new HashSet<>();

	public boolean IsTrustedNode(int node, int[][] trustGraph, int[] pretrustedPeers, int trustThreshold) {
		boolean returnValue;
		isVisted.add(node);
		for (int i = 0; i < pretrustedPeers.length; i++) {
			if (node == pretrustedPeers[i] && trustThreshold >= 0) {
				return true;
			}
		}
		for (int i = 0; i < trustGraph[node].length; i++) {
			if (trustGraph[node][i] > 0 && trustGraph[node][i] <= trustThreshold && (!isVisted.contains(i))) {
				returnValue = IsTrustedNode(i, trustGraph, pretrustedPeers, trustThreshold - trustGraph[node][i]);
				if (!returnValue) {
					isVisted.remove(node);
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int node = 0; int[][] trustGraph = { { 0, 2 }, { 2, 0 } }; int[]
		 * pretrustedPeers = { 1 }; int trustThreshold = 5;
		 */

		int node = 0;
		int[][] trustGraph = { { 0, 2, 0 }, { 2, 0, 2 }, { 0, 2, 0 } };
		int[] pretrustedPeers = { 2 };
		int trustThreshold = 5;

		/*
		 * int node=0; int[][] trustGraph= {{0,2,0},{2,0,2},{0,2,0}}; int[]
		 * pretrustedPeers= {2}; int trustThreshold=3;
		 */

		System.out.println(new IsTrusted().IsTrustedNode(node, trustGraph, pretrustedPeers, trustThreshold));

	}

}
