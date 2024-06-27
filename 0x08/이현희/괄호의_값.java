import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int mul = 1;
        int result = 0;
        boolean isValid = true;

        for (int i = 0; i < input.length; i++) {
            char data = input[i];
            if (!isValid) {
                break;
            }

            switch (data) {
                case '(':
                    stack.push(data);
                    mul *= 2;
                    break;
                case '[':
                    stack.push(data);
                    mul *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                    } else {
                        if (input[i - 1] == '(') {
                            result += mul;
                        }
                        stack.pop();
                        mul /= 2;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;
                    } else {
                        if (input[i - 1] == '[') {
                            result += mul;
                        }
                        stack.pop();
                        mul /= 3;
                    }
                    break;
            }
        }

        if (!isValid || !stack.isEmpty()) {
            result = 0;
        }

        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}
