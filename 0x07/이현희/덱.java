import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_back":
                    q.addLast(Integer.parseInt(input[1]));
                    break;
                case "push_front":
                    q.addFirst(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    if (q.isEmpty()) {
                        answer.append("-1\n");
                    } else {
                        answer.append(q.pollFirst() + "\n");
                    }
                    break;
                case "pop_back":
                    if (q.isEmpty()) {
                        answer.append("-1\n");
                    } else {
                        answer.append(q.pollLast() + "\n");
                    }
                    break;
                case "size":
                    answer.append(q.size() + "\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        answer.append("1\n");
                    } else {
                        answer.append("0\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        answer.append("-1\n");
                    } else {
                        answer.append(q.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        answer.append("-1\n");
                    } else {
                        answer.append(q.peekLast() + "\n");
                    }
                    break;
            }
        }
        bw.write(answer.toString());
        br.close();
        bw.close();
    }
}
