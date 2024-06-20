package week6;
//회전하는 큐
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj1021 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int K = Integer.parseInt(a[1]);
        for(int i = 1; i <= N; i ++) deque.addLast(i);
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< K; i++){
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            if(!deque.isEmpty()){
                while(deque.peekFirst()!=k){
                    deque.addLast(deque.pollFirst());
                    count++;
                }
                answer += Math.min(count, deque.size()-count);
                deque.pollFirst();
            }
        }
        System.out.println(answer);
        br.close();
    }
}
