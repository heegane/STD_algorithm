package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10773 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
