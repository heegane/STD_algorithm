import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] numbers = br.readLine().split(" ");
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            q.add(i);
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (number == q.peekFirst()) {
                q.pollFirst();
                continue;
            }

            int targetIndex = q.indexOf(number);
            int halfIndex = q.size() % 2 == 0 ? q.size() / 2 - 1 : q.size() / 2; // 방향 결정
            if (targetIndex <= halfIndex) {
                while (q.peekFirst() != number) {
                    q.addLast(q.pollFirst());
                    answer += 1;
                }
            } else {
                while (q.peekFirst() != number) {
                    q.addFirst(q.pollLast());
                    answer += 1;
                }
            }
            q.pollFirst();
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
