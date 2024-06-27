package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        br.close();
        boolean isOpen = true;
        Deque<Character> deque = new ArrayDeque<>();
        int answer = 0;
        for (int i=0; i<temp.length(); i++){
            char c = temp.charAt(i);
            switch (c){
                case '(':
                    deque.addLast(c);
                    isOpen = true;
                    break;
                case ')':
                    deque.pollLast();
                    if(isOpen){ //레이저인지?
                        answer += deque.size();
                    }else{ // 막대의 끝인지?
                        answer += 1;
                    }
                    isOpen = false;
                    break;
            }
        }
        System.out.println(answer);
    }
}
