package test07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class OxO7_Q1 {

    // 백준 10866 S4
    public static void main(String[] args) throws IOException {
		/*
		 1<=N<=10,000 개의 명령어 수, 6개 중 한개의 명령을 받고 정수 도출
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
            if(order.equals("push_front")) {
                int ordInt = Integer.parseInt(st.nextToken());
                deque.addFirst(ordInt);
            }else if(order.equals("push_back")) {
                int ordInt = Integer.parseInt(st.nextToken());
                deque.addLast(ordInt);
            }else if(order.equals("size")) {
                sb.append(deque.size() + "\n");
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
                    }else if(order.equals("pop_front")) {
                        sb.append(deque.pollFirst());
                    }else if(order.equals("pop_back")) {
                        sb.append(deque.pollLast());
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