import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		StringBuilder st = new StringBuilder();
		int last = -1;

		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			switch (command[0]) {
				case "push":
					last = Integer.parseInt(command[1]);
					q.add(last);
					break;
				case "pop":
					if (q.isEmpty()) {
						st.append("-1\n");
					} else {
						st.append(q.poll() + "\n");
					}
					break;
				case "size":
					st.append(q.size() + "\n");
					break;
				case "empty":
					if (q.isEmpty()) {
						st.append("1\n");
					} else {
						st.append("0\n");
					}
					break;
				case "front":
					if (q.isEmpty()) {
						st.append("-1\n");
					} else {
						st.append(q.peek() + "\n");
					}
					break;
				case "back":
					if (q.isEmpty()) {
						st.append("-1\n");
					} else {
						st.append(last + "\n");
					}
					break;
			}
		}
		bw.write(st.toString());
		br.close();
		bw.close();
	}
}