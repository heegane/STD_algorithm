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

    // 백준 6198 G5
    public static void main(String[] args) throws IOException {
		/*
		 n개의 빌딩, 오른쪽으로 진행하면서 볼 수 있는 정원의 수 체크
		 */

        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * 변수 소개
		  n : 명령어 개수
		  bld : 건물 높이 ( 스택 )
		  temp : 임시로 주어진 건물 높이
		  bldarr : 다른 건물들 옥상 확인 할 수 있는 수 배열
		  cnt : 스택에 남은 건물들의 확인할 수 있는 건물 수
		  sum : 배열 합계
		 */

        // 변수 선언
        int n = Integer.parseInt(br.readLine());
        Stack<int []> bld = new Stack<>();
        int [] bldarr = new int[n];
        for (int i = 0; i < n; i++) { // 값 입력 받으면서 빌딩 크기 비교
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());

            // 스택이 비어있지 않고, 꼭대기 갑이 현재 값보다 작은 경우에만 반복
            while (!bld.isEmpty() && bld.peek()[1] <= temp) {
                // (현재 인덱스 -1) - 스택의 꼭대기값의 인덱스 = 꼭대기 값의 확인 가능 층수
                bldarr[bld.peek()[0]] = (i - 1 - bld.peek()[0]);
                bld.pop(); // 꼭대기값 제거
            }
            bld.push(new int[] { i, temp });
            bldarr[i] = 0;
        }// for fin

        // 스택 남은 크기들 계산
        while(!bld.isEmpty()) {
            bldarr[bld.peek()[0]] = n-1-bld.peek()[0];
            bld.pop();
        }

        long sum = 0;
        // 배열 합계
        for(Integer i : bldarr) {
            sum +=i;
        }
        System.out.println(sum);
    }
}