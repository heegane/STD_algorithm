import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int currentNumber = 1;

		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());

			// currentNumber <= number -> push
			while (currentNumber <= number) {
				stack.push(currentNumber);
				result.append("+").append("\n");
				currentNumber += 1;
			}

			// currentNumber > number -> pop
			if (stack.peek() == number) {
				stack.pop();
				result.append("-").append("\n");
			} else {
				result.setLength(0); // StringBuilder 초기화
				result.append("NO");
				break;
			}
		}
		bw.write(result.toString());
		br.close();
		bw.close();
	}
}


