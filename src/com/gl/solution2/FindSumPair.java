package com.gl.solution2;

import java.util.HashSet;

public class FindSumPair {
	static class Node {
		int data;
		Node left, right;
	};

	static Node NewNode(int data) {

		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	static Node insert(Node root, int key) {
		if (root == null)
			return NewNode(key);
		if (key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}

	// traverse binary search tree by inorder way and insert node’s value into a
	// set. Also check for any node, difference between given sum and node’s value
	// in set, if it is found then pair exists otherwise it doesn’t exist.
	static boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;

		if (findpairUtil(root.left, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println(
					"Pair is found (" + (sum - root.data) + ", " + root.data + ") for the given sum value " + sum);
			return true;
		} else
			set.add(root.data);

		return findpairUtil(root.right, sum, set);
	}

	static void findPairWithGivenSum(Node root, int[] sumValues) {
		for (int i = 0; i < sumValues.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			if (!findpairUtil(root, sumValues[i], set))
				System.out.print("Nodes are not foud for the given sum value " + sumValues[i] + "\n");
		}
	}

	// Driver code
	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);
		root = insert(root, 70);

		int[] sumValues = new int[7];
		sumValues[0] = 60;
		sumValues[1] = 130;
		sumValues[2] = 110;
		sumValues[3] = 50;
		sumValues[4] = 100;
		sumValues[5] = 500;
		sumValues[6] = 10;

		findPairWithGivenSum(root, sumValues);

	}
}
