package sort;

public class BubbleSort implements ISort{

	@Override
	public void sort(int[] arr) {
		// ���� ����
		// ���÷��̽� ����
		for (int i = 0; i < arr.length - 1; i++) {	// ��ü ����Ʈ
			for (int j = 0; j < arr.length - 1 - i; j++) {	// ���ĵ� ����Ʈ�� ����
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp; 
				}
			}
		}
	}
	

}
