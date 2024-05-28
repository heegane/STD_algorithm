import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		int n = input.length();
		LinkedList<Character> list = new LinkedList<>();
		for (char c : input.toCharArray()) {
			list.add(c);
		}

		ListIterator<Character> iter = list.listIterator(n);
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			String command = br.readLine();

			if (command.startsWith("P ")) {
				char ch = command.charAt(2);
				iter.add(ch);
			} else if (command.equals("L")) {
				if (iter.hasPrevious()) {
					iter.previous();
				}
			} else if (command.equals("D")) {
				if (iter.hasNext()) {
					iter.next();
				}
			} else if (command.equals("B")) {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (char c : list) {
			result.append(c);
		}
		bw.write(result.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
