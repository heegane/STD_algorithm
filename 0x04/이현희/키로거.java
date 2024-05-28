import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			LinkedList<Character> list = new LinkedList<>();

			int index = 0;
			for (Character c : input.toCharArray()) {
				if (c.equals('<')) {
					if (index != 0)
						index -= 1;
				} else if (c.equals('>')) {
					if (index != list.size())
						index += 1;
				} else if (c.equals('-')) {
					if (index != 0) {
						index -= 1;
						list.remove(index);
					}
				} else {
					list.add(index, c);
					index += 1;
				}
			}

			StringBuilder result = new StringBuilder();
			for (char c : list) {
				result.append(c);
			}
			System.out.println(result);
		}

		br.close();
	}
}
