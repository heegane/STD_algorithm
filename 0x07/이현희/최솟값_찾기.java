import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        String[] inputAs = br.readLine().split(" ");
        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(inputAs[i]);

            // 윈도우에서 벗어나는 값 제거
            while (!deque.isEmpty() && deque.peekFirst()[1] <= i - l) {
                deque.pollFirst();
            }

            // 현재 값보다 큰 값 제거
            while (!deque.isEmpty() && deque.peekLast()[0] >= current) {
                deque.pollLast();
            }

            deque.addLast(new int[]{current, i}); // {값, index}
            sb.append(deque.peekFirst()[0]).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
