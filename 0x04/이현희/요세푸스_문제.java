import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = new LinkedList<>();
		IntStream.rangeClosed(1, n).forEach(list::add);

		StringBuilder result = new StringBuilder();
		result.append('<');

		int index = 0;
		for (int i = 0; i < n; i++) {
			index += k - 1;

			if (index >= list.size()) {
				index = index % list.size();
			}

			if (i == n - 1) {
				result.append(list.get(index)).append(">");
				break;
			}
			result.append(list.get(index)).append(", ");
			list.remove(index);
		}

		System.out.println(result);
		br.close();

	}

}
