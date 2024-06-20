import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast()[0] > num) {
                deque.pollLast();
            }

            deque.addLast(new int[]{num, i});

            if (deque.peekFirst()[1] <= i - l) {
                deque.pollFirst();
            }

            bw.write(Integer.toString(deque.peekFirst()[0])+" ");
        }
        br.close();
        bw.close();
    }
}