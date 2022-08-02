package sort;

public class BinarySearch {

	public int search(int[] arr, int target) {
		// 1. �������� �߰� �ε��� ���� ã�´�.
		// 2. �߰� �ε��� ��ġ�� �������� arr�� �������� ������. 
		// 3. ������ ������ ����Ʈ���� tartget ���� ã�´�. 
		
		int l = 0;
		int r = arr.length - 1;
		
		int m;
		while (l <= r) {
			m = l + ((r-1)/2); // prevent the overflow exception 

			if(arr[m] == target) {
				return m;
			}
			
			if (arr[m] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		
		return -1;
	}
	
}
