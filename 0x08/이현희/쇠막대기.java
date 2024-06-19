import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        int answer = 0;

        // 지금 보고 있는 닫힌 괄호가 쇠막대기인지 레이저를 의미하는지는 바로 전 괄호를 확인
        // 레이저를 쏠 때 막대기 개수는 스택의 사이즈

        for (int i = 0; i < input.length; i++) {
            String data = input[i];
            if (data.equals("(")) {
                stack.push(data);
            } else {
                if (input[i - 1].equals("(")) {
                    // 레이저
                    stack.pop();
                    answer += stack.size();
                } else {
                    // 쇠 막대기 끝
                    stack.pop();
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
