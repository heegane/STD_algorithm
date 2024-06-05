package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i< N ; i ++){
            int num = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()&&stack.peek()<=num){
                stack.pop();
                stack2.pop();
            }
            if(stack.isEmpty()){
                sb.append("0 ");
            }else{
                sb.append(stack2.peek()).append(" ");
            }
            stack.push(num);
            stack2.push(i+1);
        }
        System.out.println(sb);
    }
}
