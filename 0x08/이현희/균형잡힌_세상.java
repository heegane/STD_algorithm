import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split("");
            if (input[0].equals(".")) {
                break;
            }

            Stack<String> stack = new Stack<>();
            boolean flag = false;
            for (String data : input) {
                if (data.equals("[") || data.equals("(")) {
                    stack.push(data);
                    continue;
                }

                if (data.equals("]")) {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        continue;
                    } else {
                        flag = true;
                        break;
                    }
                }

                if (data.equals(")")) {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        flag = true;
                    }
                }
            }

            if (flag) {
                sb.append("no\n");
                continue;
            }
            if (stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
