import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for (String alpha : input) {
                if (stack.isEmpty()) {
                    stack.push(alpha);
                    continue;
                }
                if (stack.peek().equals(alpha)) {
                    stack.pop();
                } else {
                    stack.push(alpha);
                }
            }

            if (stack.isEmpty()) {
                answer += 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
