package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        br.close();
        Deque<Character> deque = new ArrayDeque<>();
        int answer = 0;
        int mulNum = 1;
        boolean isOpen = false;
        for (int i =0; i<temp.length(); i++){
            char c = temp.charAt(i);
            switch (c){
                case '(':
                    deque.addLast(c);
                    mulNum *=2;
                    isOpen =true;
                    break;
                case '[':
                    deque.addLast(c);
                    mulNum *=3;
                    isOpen =true;
                    break;
                case ')':
                    if(deque.isEmpty()||deque.peekLast() != '('){
                        System.out.println(0);
                        return;
                    }
                    if(isOpen){
                        answer += mulNum;
                    }
                    mulNum /=2;
                    deque.pollLast();
                    isOpen = false;
                    break;
                case ']':
                    if(deque.isEmpty()||deque.peekLast() != '['){
                        System.out.println(0);
                        return;
                    }
                    if(isOpen){
                        answer += mulNum;
                    }
                    mulNum /=3;
                    deque.pollLast();
                    isOpen = false;
                    break;
            }
        }
        if(!deque.isEmpty()){
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}
