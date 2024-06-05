import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
    // 백준 1874 S2
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		/*
		 	변수 소개
		 	n      : 명령어 개수
		 	stk     : 스택
		 	arr : 원하는 수열의 배열
		 	current : 현재 숫자
		 	value : 수열 숫자
		 	possible : 가능여부
		 */

        // 변수 선언
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        int [] arr = new int[n];
        boolean possible = true;
        int current = 1;

        // 원하는 수열 값 받기
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //n 개수 만큼 수열 체크
        for (int i = 0; i < n; i++) {
            int value = arr[i];
            // 수열 값이 현재 값보다 크거나 같은 경우
            if (value >= current) {
                // value까지 스택에 push
                while (value >= current) {
                    stk.push(current++);
                    sb.append("+\n");
                }
                // value를 pop
                stk.pop();
                sb.append("-\n");

            }
            // 수열 값이 현재 값보다 작은 경우
            else {
                // stack의 top이 value와 같아야 함
                if (stk.peek() == value) {
                    stk.pop();
                    sb.append("-\n");
                } else {
                    possible = false;
                    break;
                }
            }
        }

        if (possible) {
            System.out.print(sb.toString());
        } else {
            System.out.println("NO");
        }


    }
}