package com.girish.interview.bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arrays {

	public static void main(String[] args) {
		
	}

	/**
	 * Given a matrix, returns a list of all the anti diagonals.
	 */
	public static ArrayList<ArrayList<Integer>> diagonal(
			ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (a.size() == 1) {
			list.add(a.get(0));
			return list;
		}
		int col = 0, row = 0;

		for (int i = 0; row < a.size() - 1; ++i) {
			if (i < a.size()) {
				col = i;
				row = 0;
			} else {
				col = a.size() - 1;
				row = i - a.size() + 1;
			}
			int r = row;
			int c = col;
			ArrayList<Integer> antiDiagonal = new ArrayList<Integer>();
			do {
				antiDiagonal.add(a.get(r).get(c));
				r++;
				c--;
			} while (c >= 0 && r <= a.size() - 1);
			list.add(antiDiagonal);
		}
		return list;
	}

	/**
	 * Given an array of integers, returns indices of the two numbers such that
	 * they add up to a specific target.
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(target - nums[i])) {
				int ind1 = i;
				int ind2 = map.get(target - nums[i]);
				if (ind1 < ind2) {
					return new int[] { ind1, ind2 };
				} else {
					return new int[] { ind2, ind1 };
				}
			}
			map.put(nums[i], i);
		}
		return new int[] {};
	}

	/**
	 * Given a list of positive numbers, finds the permutation of these that is
	 * numerically the largest.
	 */
	public static String largestNumber(final List<Integer> a) {
		Collections.sort(a, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String one = o1 + "" + o2;
				String two = o2 + "" + o1;
				return Long.valueOf(two).compareTo(Long.valueOf(one));
			}
		});
		StringBuilder builder = new StringBuilder();
		for (int n : a) {
			builder.append(n);
		}
		int index = 0;
		while (index < builder.length() - 1 && builder.charAt(index) == '0')
			index++;
		return builder.substring(index, builder.length());
	}

	/**
	 * Finds the maximum sub-array of non negative numbers from an array. If
	 * there is a tie, then returns the segment which has maximum length. If
	 * there is still a tie, then returns the segment with minimum starting
	 * index.
	 */
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		long maxSum = Long.MIN_VALUE;
		long sum = 0;
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); ++i) {
			if (a.get(i) < 0) {
				sum = 0;
				list.clear();
				continue;
			} else {
				list.add(a.get(i));
				sum += a.get(i);
				if (sum == maxSum) {
					if (list.size() > maxList.size()) {
						maxList.clear();
						for (int n : list) {
							maxList.add(n);
						}
					}
				} else if (sum > maxSum) {
					maxSum = sum;
					maxList.clear();
					for (int n : list) {
						maxList.add(n);
					}
				}
			}
		}
		return maxList;
	}

	/**
	 * Given a matrix, if ij has a 0, makes row i and column j all 0s.
	 */
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		ArrayList<Integer> rows = new ArrayList<>(a.size());
		ArrayList<Integer> columns = new ArrayList<>(a.get(0).size());
		for (int i = 0; i < a.size(); ++i) {
			rows.add(0);
		}
		for (int i = 0; i < a.get(0).size(); ++i) {
			columns.add(0);
		}
		for (int i = 0; i < a.size(); ++i) {
			for (int j = 0; j < a.get(0).size(); ++j) {
				if (a.get(i).get(j) == 0) {
					rows.set(i, 1);
					columns.set(j, 1);
				}
			}
		}
		ArrayList<Integer> empty = new ArrayList<>(a.get(0).size());
		for (int i = 0; i < a.get(0).size(); ++i) {
			empty.add(0);
		}
		for (int r = 0; r < rows.size(); ++r) {
			if (rows.get(r) == 1) {
				a.set(r, empty);
			}
		}
		for (int c = 0; c < columns.size(); ++c) {
			if (columns.get(c) == 1) {
				for (ArrayList<Integer> row : a) {
					row.set(c, 0);
				}
			}
		}
	}

	/**
	 * Prints a matrix, given the matrix, the # of rows and the # of columns.
	 */
	private static void printMatrix(ArrayList<ArrayList<Integer>> a, int rows,
			int columns) {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < columns; ++j) {
				System.out.print(a.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Given an array of size N, that only contains numbers from 0 to N-1, finds
	 * the number that occurs the most. Uses O(1) space.
	 * 
	 * @return the number that appears the most.
	 */
	public static int findMostOccurringNumber(int[] values) {
		for (int i = 0; i < values.length; ++i) {
			int expectedIndex = values[i];
			if (values[i] <= -1)
				continue;
			if (values[expectedIndex] <= -1)
				values[expectedIndex]--;
			else if (expectedIndex < i) {
				values[expectedIndex] = -1;
			} else if (values[expectedIndex] >= 0) {
				int temp = values[expectedIndex];
				values[expectedIndex] = -1;
				values[i] = temp;
				i--;
			}
		}
		int min = Integer.MAX_VALUE;
		int number = Integer.MIN_VALUE;
		for (int i = 0; i < values.length; ++i) {
			if (values[i] < min) {
				min = values[i];
				number = i;
			}
		}
		return number;
	}

	/**
	 * Given an array of size N, that only contains numbers from 0 to N-1, finds
	 * the number that occurs the most. Uses O(N) extra space.
	 * 
	 * @return the number that appears the most.
	 */
	public static int findMostOccurringNumberNiave(int[] values) {
		int[] array = new int[values.length];
		for (int n : values)
			array[n]++;
		int max = array[0];
		int num = 0;
		for (int i = 0; i < array.length; ++i) {
			if (array[i] > max) {
				max = array[i];
				num = i;
			}
		}
		return num;
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