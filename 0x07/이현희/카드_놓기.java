import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    q.addFirst(i);
                    break;
                case 2:
                    int top = q.pollFirst();
                    q.addFirst(i);
                    q.addFirst(top);
                    break;
                case 3:
                    q.addLast(i);
                    break;
            }
        }

        while (!q.isEmpty()) {
            answer.append(q.pollFirst() + " ");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}
