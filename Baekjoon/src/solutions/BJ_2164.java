package solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164 {

	public static void main(String[] args) {
		//input
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		//logic
		Queue<Integer> queue = new LinkedList<>();
		for (int i=0; i < N; i++) { //4
			queue.add(i+1);	//1,2,3,4
		}

		int count = 1;
		while(queue.size() != 1) {
			int q = queue.poll();
			if (count%2 == 0) {
				queue.offer(q);
			}
			System.out.println(count + " -> " + queue);
			count++;
		}
		
		System.out.println(queue.peek());
		
	}
	
	
}
