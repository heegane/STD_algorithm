package week6;
//카드 놓기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] commandArr = new int[N+1];
        for(int i = N; i>0;i--){
            commandArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=N;i++){
            switch (commandArr[i]){
                case 1:
                    deque.addFirst(i);
                    break;
                case 2:
                    int temp = deque.pollFirst();
                    deque.addFirst(i);
                    deque.addFirst(temp);
                    break;
                case 3:
                    deque.addLast(i);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}
