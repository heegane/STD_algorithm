import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		IntStream.rangeClosed(1, n).forEach(q::add);

		int term = 1;
		while (q.size() > 1) {
			if (term % 2 != 0) {
				q.poll();
			} else {
				q.add(q.poll());
			}
			term += 1;
		}
		bw.write(String.valueOf(q.peek()));
		br.close();
		bw.close();
	}
}