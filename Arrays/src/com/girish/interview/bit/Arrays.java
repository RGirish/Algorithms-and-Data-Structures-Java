package com.girish.interview.bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arrays {

	public static void main(String[] args) {
		List<Integer> X = new ArrayList<>();
		X.add(0);
		X.add(1);
		X.add(2);
		System.out.println(firstMissingPositive(X));
	}

	/**
	 * Given an unsorted integer array, finds the first missing positive
	 * integer.
	 */
	public static int firstMissingPositive(List<Integer> a) {
		int N = a.size();
		boolean[] array = new boolean[N];
		for (int i : a)
			if (i >= 1 && i <= N)
				array[i - 1] = true;
		int k = 0;
		for (k = 0; k < N; ++k)
			if (!array[k])
				return k + 1;
		return N + 1;
	}

	/**
	 * Returns the max value of | A[i] - A[j] | + | i - j |
	 */
	public static int maxArr(List<Integer> A) {
		List<Integer> sum = new ArrayList<>();
		List<Integer> diff = new ArrayList<>();
		for (int i = 0; i < A.size(); ++i) {
			sum.add(A.get(i) + (i + 1));
			diff.add(A.get(i) - (i + 1));
		}
		Collections.sort(sum);
		Collections.sort(diff);
		return Math.max(sum.get(sum.size() - 1) - sum.get(0),
				diff.get(diff.size() - 1) - diff.get(0));
	}

	/**
	 * Given the digits of a number as an array, returns the array after adding
	 * one to that number.
	 */
	public static List<Integer> plusOne(List<Integer> a) {
		int i = a.size() - 1;
		int sum = a.get(i) + 1;
		for (; i > 0 && sum == 10; --i) {
			a.set(i, 0);
			sum = a.get(i - 1) + 1;
		}
		// if i > 0, it means, the array is complete.
		if (sum != 10) {
			a.set(i, sum);
		}
		// If it isn't, then it is 0, and it means that we need to add an extra
		// one at the beginning of the array.
		else {
			a.set(0, 0);
			a.add(0, 1);
		}
		while (a.get(0) == 0)
			a.remove(0);
		return a;
	}

	/**
	 * An implementation of Kadane's Algorithm to find the max sum of a
	 * sub-array of length at least 1.
	 */
	public static int maxSubArray(final List<Integer> a) {
		int globalMax = 0, localMax = 0;
		if (a.get(0) < 0) {
			localMax = a.get(0);
			globalMax = a.get(0);
		}
		for (int i : a) {
			localMax = Math.max(localMax + i, i);
			globalMax = Math.max(globalMax, localMax);
		}
		return globalMax;
	}

	/**
	 * Calculates the minimum # of steps needed to cover the given points in
	 * order. X and Y coordinates of the points in order. Each point is
	 * represented by (X.get(i), Y.get(i))
	 */
	public static int coverPoints(List<Integer> X, List<Integer> Y) {
		int steps = 0;
		for (int i = 0; i < X.size() - 1; ++i) {
			steps += stepsBetween(X.get(i), Y.get(i), X.get(i + 1),
					Y.get(i + 1));
		}
		return steps;
	}

	/**
	 * Calculates the minimum # of steps between the given 2 points.
	 */
	public static int stepsBetween(int x1, int y1, int x2, int y2) {
		int steps = 0;
		for (; x1 != x2 && y1 != y2; ++steps) {
			if (x1 < x2 && y1 < y2) {
				x1++;
				y1++;
			} else if (x1 > x2 && y1 > y2) {
				x1--;
				y1--;
			} else if (x1 < x2 && y1 > y2) {
				x1++;
				y1--;
			} else if (x1 > x2 && y1 < y2) {
				x1--;
				y1++;
			}
		}
		if (y1 == y2 && x1 != x2)
			steps += Math.abs(x1 - x2);
		if (x1 == x2 && y1 != y2)
			steps += Math.abs(y1 - y2);
		return steps;
	}
}