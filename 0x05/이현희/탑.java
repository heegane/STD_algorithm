import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		// [높이, 번호]
		Stack<int[]> stack = new Stack<>();

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		StringBuilder answer = new StringBuilder();

		for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
			int currentHeight = Integer.parseInt(st.nextToken());

			// stack이 비었을 때
			if (stack.isEmpty()) {
				answer.append(0).append(" ");
				stack.push(new int[] {currentHeight, currentNumber});
			}
			// stack이 비어 있지 않을 때
			else {
				int topHeight = stack.peek()[0];
				int topNumber = stack.peek()[1];

				// 바로 앞에 현재 탑의 수신을 받을 수 있는 탑이 있을 때
				if (topHeight >= currentHeight) {
					answer.append(topNumber).append(" ");
					stack.push(new int[] {currentHeight, currentNumber});
					continue;
				}

				// 바로 앞에 현재 탑의 수신을 받을 수 있는 탑이 없을 때
				// pop()해 가면서 수신을 받을 수 있는 탑이 있는지 확인
				stack.pop();
				while (!stack.isEmpty()) {
					topHeight = stack.peek()[0];
					topNumber = stack.peek()[1];

					if (topHeight >= currentHeight) {
						answer.append(topNumber).append(" ");
						stack.push(new int[] {currentHeight, currentNumber});
						break;
					} else {
						stack.pop();
					}
				}

				// stack이 비어 있다 -> 현재 탑의 수신을 받아줄 탑이 없다는 걸 의미
				if (stack.isEmpty()) {
					answer.append(0).append(" ");
					stack.push(new int[] {currentHeight, currentNumber});
				}
			}
		}
		bw.write(answer.toString());
		br.close();
		bw.close();
	}
}