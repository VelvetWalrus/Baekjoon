package sort;

public class InsertionSort implements ISort {

	@Override
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i]; // data for searching insertion point
			int j = i - 1;	// 0 - j sorted sublist
			while (j >=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j + 1] = key;
		}
		
	}

}
