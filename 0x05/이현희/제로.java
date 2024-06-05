import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(num);
			}
		}
		int sum = stack.stream().mapToInt(Integer::intValue).sum();
		bw.write(String.valueOf(sum));
		br.close();
		bw.close();
	}
}


