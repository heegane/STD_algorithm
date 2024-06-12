import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder st = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			switch (command[0]) {
				case "push":
					q.add(Integer.parseInt(command[1]));
					break;
				case "pop":
					if (q.isEmpty()) {
						st.append("-1\n");
					} else {
						st.append(q.pollFirst() + "\n");
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
						st.append(q.peekFirst() + "\n");
					}
					break;
				case "back":
					if (q.isEmpty()) {
						st.append("-1\n");
					} else {
						st.append(q.peekLast() + "\n");
					}
					break;
			}
		}
		bw.write(st.toString());
		br.close();
		bw.close();
	}
}