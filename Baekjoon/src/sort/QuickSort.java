package sort;

public class QuickSort implements ISort{

	@Override
	public void sort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	private void quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		
		int pivot = low + ((high - low) / 2);
		int pivotValue = arr[pivot];
		
		int left = low;
		int right = high;
		while (left <= right) {
			while (arr[left] < pivotValue) {
				left++;
			}
			
			while (arr[right] > pivotValue) {
				right--;
			}
			
			if (left <= right) {
				int tmp = arr[right];
				arr[right] = arr[left];
				arr[left] = tmp;
				left++;
				right--;
			}
		}
		
		quickSort(arr, low, right); // left sublist
		quickSort(arr, low, high);	// right sublist
	}

}
