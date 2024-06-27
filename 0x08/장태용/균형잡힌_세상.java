package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class boj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String temp = br.readLine();
            if(Objects.equals(temp, ".")){
                break;
            }
            boolean isError = false;
            Deque<Character> deque = new ArrayDeque<>();
            for(int i = 0; i<temp.length(); i++){

                char c = temp.charAt(i);
                switch (c){
                    case '[':
                        deque.addLast(c);
                        break;
                    case '(':
                        deque.addLast(c);
                        break;
                    case ']':
                        if (deque.isEmpty() || deque.peekLast() != '['){
                            isError = true;
                            break;
                        }
                        deque.pollLast();
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
            if(deque.isEmpty() && !isError){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }
        br.close();
    }
}
