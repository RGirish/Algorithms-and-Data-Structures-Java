package girish.ctci.project;

import java.lang.reflect.Array;

public class Sort {

	public static void main(String[] args) {
		int[] unsortedArray = { 140, 79, 964, 27, 801, 251 };
		printArray(unsortedArray);
		int[] sortedArray = quickSort(unsortedArray);
		printArray(sortedArray);
	}

	static int[] quickSort(int[] unsortedarray) {
		if (count(unsortedarray) <= 1)
			return unsortedarray;
		qSort(unsortedarray, 0, count(unsortedarray) - 1);
		return unsortedarray;
	}

	public static void qSort(int[] array, int lo, int hi) {
		if (hi - lo == 0) { // 1 element
			return;
		} else if (hi - lo == 1) { // 2 elements
			if (array[lo] > array[hi]) {
				int temp = array[lo];
				array[lo] = array[hi];
				array[hi] = temp;
				return;
			}
		}
		int pivotIndex = partition(array, lo, hi);
		qSort(array, lo, pivotIndex - 1);
		qSort(array, pivotIndex + 1, hi);
	}

	static int partition(int[] array, int lo, int hi) {
		int pivot = array[hi];
		int left = lo;
		int right = hi - 1;
		while (true) {
			while (left <= right) {
				if (array[left] < pivot)
					left++;
				else
					break;
			}
			while (right >= left) {
				if (array[right] >= pivot)
					right--;
				else
					break;
			}
			if (left >= right) {
				break;
			}
			// swap out of order items
			int temp = array[right];
			array[right] = array[left];
			array[left] = temp;
		}

		int temp = array[hi];
		array[hi] = array[left];
		array[left] = temp;
		return left;
	}

	/*
	 * Bubble Sort
	 */
	static int[] bubbleSort(int[] unsortedarray) {
		int count = count(unsortedarray);
		for (int i = count; i >= 0; --i) {
			for (int j = 0; j < i - 1; ++j) {
				if (unsortedarray[j] > unsortedarray[j + 1]) {
					unsortedarray[j] = unsortedarray[j] + unsortedarray[j + 1];
					unsortedarray[j + 1] = unsortedarray[j] - unsortedarray[j + 1];
					unsortedarray[j] = unsortedarray[j] - unsortedarray[j + 1];
				}
			}
		}
		return unsortedarray;
	}

	/*
	 * General use methods.
	 */
	static int count(int[] array) {
		return Array.getLength(array);
	}

	static void printArray(int[] array) {
		int n = count(array);
		System.out.println("\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(array[i] + " ");
		}
	}
}