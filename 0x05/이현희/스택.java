import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			String command = input[0];

			switch (command) {
				case "push":
					stack.push(Integer.parseInt(input[1]));
					break;
				case "pop":
					if (stack.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(String.valueOf(stack.pop()));
					}
					bw.newLine();
					break;
				case "size":
					bw.write(String.valueOf(stack.size()));
					bw.newLine();
					break;
				case "empty":
					if (stack.isEmpty()) {
						bw.write("1");
					} else {
						bw.write("0");
					}
					bw.newLine();
					break;
				case "top":
					if (stack.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(String.valueOf(stack.peek()));
					}
					bw.newLine();
					break;
			}
		}
		br.close();
		bw.close();
	}
}


