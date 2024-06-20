package test07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class OxO7_Q5_2 {

    public static StringBuilder sb = new StringBuilder();
    // 백준 18115 S3
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); 	// n : 카드 수

        // 수열 A deq에 저장, 뒤에서 부터 빼서 행동 비교할 것
        Deque<Integer> deqA = new ArrayDeque<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            deqA.add(Integer.parseInt(st.nextToken()));
        }

        // 제일 처음의 카드  Linkedlist, index로 넣을 거라서 Linkedlist로 구현
        LinkedList<Integer> linkFirst = new LinkedList<Integer>();
        int temp = 1;   // 1~n 순서로 넣을 값 체크
        while(true) {
            // 수열의 값 역순으로 조회
            if(!deqA.isEmpty()) {
                int tempDa = deqA.pollLast();
                if(!linkFirst.isEmpty()) {
                    // 1인 경우 맨 앞에 추가
                    if(tempDa == 1) {
                        linkFirst.addFirst(temp);
                    }
                    // 2인 경우 1번 인덱스에 값 추가
                    else if(tempDa==2) {
                        linkFirst.add(1,temp);
                    }
                    // 3인 경우 맨 뒤에 추가
                    else {
                        linkFirst.addLast(temp);
                    }
                }
                // 비어 있는 경우 -> 제일 처음 값 = 무조건 그냥 넣기
                else {
                    linkFirst.add(temp);
                }
                temp++;
            }else {
                break;
            }
        }// while fin
        for(Integer link : linkFirst) {
            sb.append(link + " ");
        }
        System.out.println(sb.toString().trim());

    }
}



