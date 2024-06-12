package test06;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class OxO6_Q3 {

    // 백준 2164 S4
    public static void main(String[] args) throws IOException {
		/*
		 정수 1<=N<=500,000개 젤위버리고, 그다음꺼 젤밑으로 다시 젤위 버리고 ... 반복
		 */
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 	변수 소개
		 	n      : 명령어 개수
		 	deque     : 큐
		 	cnt : 현재 위에서 카드를 없애는 순서인지, 밑으로 넣는 순서인지 구분하기 위한 변수
		 */
        // 변수 선언
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        // n만큼 값 넣기, 최종적으로 큐에 위에서부터 [1,2,3,4]순으로 저장되어야 하므로
        // addfirst로 앞에서부터 값을 넣는다.
        for(int i = 1; i<=n; i++) {
            deque.addFirst(i);
        }

        // while 문 시작, deque의 크기가 1되면 while문 종료
        int cnt = 0;
        while(deque.size()>1) {
            // 짝수 번째 -> 젤 위의 값 제거
            if(cnt%2 ==0) {
                deque.removeLast();
            }
            // 홀수 번째 -> 젤 위의 값 빼서 젤 밑에 넣기
            else {
                deque.addFirst(deque.pollLast());
            }
            cnt++;
        }
        // 출력
        System.out.println(deque.getFirst());

    }
}