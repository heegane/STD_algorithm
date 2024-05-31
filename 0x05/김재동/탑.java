import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    // 백준 2493 G5
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		/*
		 * 변수 소개
		  n : 명령어 개수
		  top : 탑 높이 ( 스택 )
		  temp : 임시로 주어진 탑 높이
		  toparr : 해당 탑의 인덱스
		 */

        // 변수 선언
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int []> top = new Stack<>();
        ArrayList<Integer> toparr = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());

            // top이 비어있기 전까지
            while (!top.isEmpty()) {
                // top의 꼭대기 값이 현재 값보다 작은 경우
                if (top.peek()[1] < temp) {
                    top.pop();
                }
                // top의 꼭대기 값이 현재 값보다 큰 경우
                else {
                    sb.append(top.peek()[0] + " ");
                    break;
                }
            }

            // 만약 반복문 통해 스택이 비어진 경우 -> 현재 값이 가장 큼
            if (top.isEmpty()) {
                sb.append("0 ");
            }
            top.push(new int[] {i,temp});
        } // 값 입력받는 반복문 fin



        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}