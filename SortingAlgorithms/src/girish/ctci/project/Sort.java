package girish.ctci.project;

public class Sort {

	public static void main(String[] args) {
		int[] array = { 140, 79, 964, 27, 801, 251 };
		/*
		 * printArray(array); bubbleSort(array); printArray(array);
		 */
		int[] result = merge(new int[] { 1, 3, 5, 9 }, new int[] { 20, 24, 26 });
		printArray(result);
	}

	static int[] quickSort(int[] array) {
		if (array.length <= 1)
			return array;
		qSort(array, 0, array.length - 1);
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
		int count = array.length;
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
		int count = array.length;
		for (int i = 0; i < count - 1; ++i) {
			int minPos = i;
			for (int j = i + 1; j < count; ++j)
				if (array[j] < array[minPos])
					minPos = j;
			if (minPos != i) {
				int temp = array[i];
				array[i] = array[minPos];
				array[minPos] = temp;
			}
		}
	}

	/*
	 * Insertion Sort
	 */
	static void insertionSort(int[] array) {
		int count = array.length;
		int element, j = 0;
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
	 * Merge Sort
	 */

	static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		int i = 0, aPos = 0, bPos = 0;
		while (i < result.length) {
			if (aPos < a.length && bPos == b.length) {
				result[i++] = a[aPos++];
				continue;
			}
			if (bPos < b.length && aPos == a.length) {
				result[i++] = b[bPos++];
				continue;
			}
			result[i++] = (a[aPos] < b[bPos]) ? a[aPos++] : b[bPos++];
		}
		return result;
	}

	static void printArray(int[] array) {
		int n = array.length;
		System.out.println("\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(array[i] + " ");
		}
	}
}