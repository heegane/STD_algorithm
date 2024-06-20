package week6;
//최소값 찾기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int L = Integer.parseInt(line[1]);
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!deque2.isEmpty()&&i-deque2.peekFirst() >= L){
                deque.pollFirst();
                deque2.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast()>=num)
            {
                deque.pollLast();
                deque2.pollLast();
            }
            deque.addLast(num);
            deque2.addLast(i);
            sb.append(deque.peekFirst()).append(" ");

        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}
