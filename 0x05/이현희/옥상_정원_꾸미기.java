import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		long count = 0;

		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(br.readLine());

			// 현재 건물이 스택의 맨 위 건물보다 높을 때 스택에서 건물을 꺼냄
			while (!stack.isEmpty() && stack.peek() <= height) {
				stack.pop();
			}

			// 스택에 남아 있는 건물들은 현재 건물의 옥상을 볼 수 있음
			count += stack.size();

			// 현재 건물을 스택에 추가
			stack.push(height);
		}

		bw.write(Long.toString(count));
		br.close();
		bw.close();
	}
}
