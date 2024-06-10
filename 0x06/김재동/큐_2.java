package test06;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class OxO6_Q2 {

    // 백준 18258 S4
    public static void main(String[] args) throws IOException {
		/*
		 1<=N<=2,000,000 개의 명령어 수, 6개 중 한개의 명령을 받고 정수 도출
		 1<=x<=100,000 정수 이므로 입력 받으면서 바로 계산하게끔 구현
		 */
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		/*
		 	변수 소개
		 	n      : 명령어 개수
		 	deque     : 큐
		 	ord    : 명령어
		 	ordInt : 명령어 숫자
		 */
        // 변수 선언
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<n; i++) { // 반복문 시작
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            // 큐의 비어있는 여부와 관련 없는 명령어부터 체크
            if(order.equals("size")) {
                sb.append(deque.size() + "\n");
            }else if(order.equals("push")) {
                int ordInt = Integer.parseInt(st.nextToken());
                deque.add(ordInt);
            }
            // 여기서 부턴 비어있는지 체크
            else {
                // 값 있는 경우
                if(!deque.isEmpty()) {
                    if(order.equals("pop")) {
                        sb.append(deque.poll());
                    }else if(order.equals("empty")) {
                        sb.append("0");
                    }else if(order.equals("front")) {
                        sb.append(deque.getFirst());
                    }else if(order.equals("back")) {
                        sb.append(deque.getLast());
                    }
                }
                // 없는 경우
                else {
                    if(order.equals("empty")) {
                        sb.append("1");
                    }else {
                        sb.append("-1");
                    }
                }
                // 공백 추가
                if(i<n-1) {
                    sb.append("\n");
                }
            }// 명령어 체크 반복문 fin
        }// 값 입력받는 반복문 fin
        // 마지막 공백 제거
        System.out.println(sb.toString().trim());
    }
}