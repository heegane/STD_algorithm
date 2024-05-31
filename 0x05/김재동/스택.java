import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    // 백준 10828 S4
    public static void main(String[] args) throws IOException {
		/*
		 1<=N<=10000 개의 명령어 수,
		 5개 중 한개의 명령을 받고 그 명령에 따른 결과값 도출하기
		 */
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		/*
		 	변수 소개
		 	n      : 명령어 개수
		 	stk     : 스택
		 	ord    : 명령어
		 	ordInt : 명령어 숫자
		 */

        // 변수 선언
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        // 명령어 수 만큼 반복문
        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ord = st.nextToken();

            // 명령어 start
            if(ord.equals("push")) {
                int ordInt = Integer.parseInt(st.nextToken());
                stk.add(ordInt);
                continue;
            }else if(ord.equals("pop")) {
                if(!stk.empty()) {
                    sb.append(stk.pop());
                }else {
                    sb.append("-1");
                }
            }else if(ord.equals("size")) {
                sb.append(stk.size());
            }else if(ord.equals("empty")){
                if(!stk.empty()) {
                    sb.append("0");
                }else {
                    sb.append("1");
                }
            }else if(ord.equals("top")) {
                if(!stk.empty()) {
                    sb.append(stk.peek());
                }else {
                    sb.append("-1");
                }
            } // 명령어 fin

            // 빈칸 추가
            if(i<n) {
                sb.append("\n");
            }
        } // 반복문 끝

        System.out.println(sb.toString());
    }
}