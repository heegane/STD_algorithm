import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 백준 1158 S4
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
		/*
		 	변수 소개
		 	n : 사람 수
		 	k : 제거할 번호
		 	원형 리스트 이므로 que 활용
		 */
        // 변수 선언 및 값 받기
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<Integer>();

        // n만큼 que에 저장
        for(int i=1; i<=n; i++) {
            que.offer(i);
        }

        sb.append("<");

        // que가 비었을 때까지 진행
        while(!que.isEmpty()) {
            for(int i = 0; i<k-1; i++) {
                que.offer(que.poll());
            }
            sb.append(que.poll());
            if(!que.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        // 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}