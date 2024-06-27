package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i=0 ; i<N ; i++){
            String temp = br.readLine();
            Deque<Character> deque = new ArrayDeque<>();
            for (int j =0; j<temp.length();j++){
                char c = temp.charAt(j);
                if(!deque.isEmpty()&&deque.peekLast()==c){
                    deque.pollLast();
                }else{
                    deque.addLast(c);
                }
            }
            if (deque.isEmpty()){
                answer +=1;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
