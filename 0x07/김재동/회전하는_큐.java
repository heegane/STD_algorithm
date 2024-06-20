package test07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class OxO7_Q2 {

    // 백준 1021 S3
    public static void main(String[] args) throws IOException {
		/*
		1<=n<=50, m<=n
		 */
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

		/*
		n : 1~n까지의 수
		m : 뽑아낼 자연 수 개수
		deq : 1~n까지의 값 저장한 deque
		want : 뽑아낼 자연수 어레이리스트
		*/
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> deq = new ArrayList<>();
        List<Integer> wantList = new ArrayList<>();

        // 1~n까지 deq에 저장
        for(int i =1; i<=n; i++) {
            deq.add(i);
        }
        // 뽑아낼 값 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++) {
            wantList.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        while(true) {
            // 이미 비교 다 한 경우
            if(wantList.size()==0) {
                break;
            }
            // 만약 deq의 첫 번째 값과, 원하는 값이 같은 경우
            if (deq.get(0) == wantList.get(0)) {
                deq.remove(0);
                wantList.remove(0); // List 맨 앞 제거
            }
            // 다른 경우
            else {
                int deqIndex = deq.indexOf(wantList.get(0)); // 원하는 값의 deq 인덱스
                int deqSize = deq.size();	// 현재 deq 크기
                // 만약 전체크기의 반보다 원하는 deq의 인덱스가 크다
                // => 현재 기준 왼쪽으로 이동해야 가까움
                // 왼쪽이동
                if (deqSize/2 >= deqIndex) {
                    deq.add(deq.get(0)); // deq의 맨 뒤에 현재 맨 앞의 값 추가
                    deq.remove(0);		 // 현재 맨 앞 제거
                }
                // 오른쪽 이동
                else {
                    deq.add(0,deq.get(deq.size()-1)); // deq의 맨 앞에 젤 뒷 값 추가
                    deq.remove(deq.size()-1); // deq의 맨 뒷 값 제거
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}