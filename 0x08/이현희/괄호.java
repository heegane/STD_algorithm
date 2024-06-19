import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            boolean isValid = true;

            for (String data : input) {
                if (data.equals("(")) {
                    stack.push(data);
                    continue;
                }
                if (data.equals(")")) {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }

                    if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            if (!isValid || !stack.isEmpty()) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
