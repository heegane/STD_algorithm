package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            Deque<Character> deque = new ArrayDeque<>();
            String temp = br.readLine();
            boolean isError = false;
            for(int j = 0; j<temp.length(); j++){
                char c = temp.charAt(j);
                switch (c){
                    case '(':
                        deque.addLast(c);
                        break;
                    case ')':
                        if(deque.isEmpty() || deque.peekLast() != '('){
                            isError = true;
                            break;
                        }
                        deque.pollLast();
                        break;
                }
            }
            if (deque.isEmpty()&&!isError){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        br.close();
    }
}
