import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        long answer = 0;

        // 이름 길이 별로 큐 생성
        Queue<Integer>[] arr = new Queue[21];
        for (int i = 0; i <= 20; i++) {
            arr[i] = new LinkedList<>();
        }

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            int len = name.length();

            // 큐가 비어 있지 않고 현재 인덱스와 맨 앞 인덱스의 차이가 k보다 크면 큐에서 제거
            while (!arr[len].isEmpty() && i - arr[len].peek() > k) {
                arr[len].poll();
            }

            // 현재 큐에 남아 있는 모든 요소는 i와 짝을 이룰 수 있음
            answer += arr[len].size();

            // 현재 인덱스를 큐에 추가
            arr[len].add(i);
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
