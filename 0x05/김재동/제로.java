import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
    // 백준 10773 S4
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		/*
		 	변수 소개
		 	n      : 명령어 개수
		 	stk     : 스택
		 	ordInt : 받은 숫자
		 	sum : 합계
		 */

        // 변수 선언
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        int sum = 0;

        for(int i =0 ; i<n; i++) {
            int ordInt = Integer.parseInt(br.readLine());
            if(ordInt == 0) {
                stk.pop();
            }else {
                stk.add(ordInt);
            }
        }

        for(int i : stk) {
            sum += i;
        }
        System.out.println(sb.append(sum).toString());
    }
}




