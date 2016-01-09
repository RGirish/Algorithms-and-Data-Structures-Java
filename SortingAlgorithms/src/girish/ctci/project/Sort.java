package girish.ctci.project;

import java.lang.reflect.Array;

public class Sort {

	public static void main(String[] args) {
		int[] array = { 140, 79, 964, 27, 801, 251 };
		printArray(array);
		insertionSort(array);
		printArray(array);
	}

	static int[] quickSort(int[] array) {
		if (count(array) <= 1)
			return array;
		qSort(array, 0, count(array) - 1);
		return array;
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
	static void bubbleSort(int[] array) {
		int count = count(array);
		for (int i = count; i > 0; --i) {
			for (int j = 0; j < i - 1; ++j) {
				if (array[j] > array[j + 1]) {
					array[j] = array[j] + array[j + 1];
					array[j + 1] = array[j] - array[j + 1];
					array[j] = array[j] - array[j + 1];
				}
			}
		}
	}

	/*
	 * Selection Sort
	 */
	static void selectionSort(int[] array) {
		int count = count(array);
		for (int i = 0; i < count - 1; ++i) {
			int min = i;
			for (int j = i; j < count; ++j)
				if (array[j] < array[min])
					min = j;
			if (min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
	}

	/*
	 * Insertion Sort
	 */
	static void insertionSort(int[] array) {
		int count = count(array);
		int element = 0, j = 0;
		for (int i = 1; i < count; ++i) {
			element = array[i];
			j = i;
			while (j > 0 && array[j - 1] > element) {
				array[j] = array[j - 1];
				j = j - 1;
			}
			array[j] = element;
		}
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