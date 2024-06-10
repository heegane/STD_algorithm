package test06;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class OxO6_Q5 {
    // 백준 3078 G4
    public static void main(String[] args) throws IOException {
		/*
		3<=n<=300,000, 1<=k<=n 이름 글자수 : 2~20, 이름 같은 수, 성적 비교해서 체크
		deque에 인덱스 번호와 글자 길이 넣은 후
		글자길이가 k와 다르면 안넣기
		이후 체크..?
		*/
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 변수 선언
		 n : 학생 수
		 k : 최대로 차이나는 등수
		 deq : 인덱스와 문자열 길이 넣을 deque
		 dlMap : deq의 길이 저장
		*/
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> deq = new LinkedList<>();
        Map<Integer, Integer> dlMap = new HashMap<Integer, Integer>();

		/*
		먼저 deque에 글자 수 맞는 값 넣기
		l : 문자열 길이
		deqL : deq 맨앞의 길이
		sum : 쌍의 합
		*/
        long sum = 0;
        for(int i =0; i<n; i++) {
            int l = br.readLine().length();
            // deq의 크기가 k보다 큰 경우 ( 맨 앞의 값은 조건에 해당x )
            if(deq.size()>k) {
                int deqL = deq.poll();
                // deq의 맨 앞의 길이에서 있으면 1개 빼고, 없으면 0
                dlMap.put(deqL,dlMap.getOrDefault(deqL, 0)-1);
            }
            // 입력받은 이름의 길이 중복된 만큼 누적
            sum += dlMap.getOrDefault(l, 0);
            deq.add(l);
            // 해당 값 중복이면 +1해서 hashmap에 저장
            dlMap.put(l,dlMap.getOrDefault(l, 0)+1);
        }

        System.out.println(sum);

    }


}