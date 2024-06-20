package test07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class OxO7_Q4_3 {

    public static StringBuilder sb = new StringBuilder();
    // 백준 11003 F5
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n개의 수, l개 비교
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        Deque<int []> deq = new LinkedList<>();
        for(int i= 0 ; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            // deq가 안비어있고, deq에 남은 값이 새로 입력한 값보다 작을 때까지 deq에 남은 값들 정리
            while(!deq.isEmpty()&&deq.peekLast()[0]>temp) {
                deq.pollLast();
            }
            // deq에 새로 입력 받은 값과 인덱스 저장
            deq.add(new int[] {temp,i});
            // deq의 peekFirst의 인덱스 범위가 l보다 큰 경우 맨 앞 정리
            if(deq.peekFirst()[1]<=i-l) {
                deq.pollFirst();
            }
            // 맨 앞 값이 최소값이므로 추가
            sb.append(deq.peekFirst()[0] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}