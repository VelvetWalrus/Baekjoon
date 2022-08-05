package queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	static class Task {
		int priority;
		String title;
		
		public Task(int priority, String title) {
			this.priority = priority;
			this.title = title;
		}
	}
	
	public static void main(String[] args) {
		PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> {
			return t1.priority - t2.priority; // t1, t2�� �ٲ� ��� ���� ���� - ordered by priority
			// return t1.title.compareTo(t2.title); // ordered by context
		});
		
		pq.add(new Task(4, "Ű���� û���ϱ�"));
		pq.add(new Task(1, "�˰��� ���� Ǯ��"));
		pq.add(new Task(3, "��� ���� ã�ƺ���"));
		pq.add(new Task(2, "��Ʈ������ �����ϱ�"));
		
		while (!pq.isEmpty()) {
			Task task = pq.poll();
			System.out.println("[�߿䵵: " + task.priority + "] " + task.title);
			
		}
		
		
		
	}
	
	
}
