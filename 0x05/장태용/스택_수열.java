package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = N; i > 0; i--){
            stack2.push(i);
        }
        try{
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                if(stack1.isEmpty()){
                    stack1.push(stack2.pop());
                    sb.append("+\n");
                }
                if(stack1.peek()==num){
                    stack1.pop();
                    sb.append("-\n");
                }else{
                    while(stack1.peek()!=num){//만약 해당 수열을 만들 수 없다면 이부분에서 Exception이 생기므로 try catch구문으로 처리하였음.ㅊ
                        stack1.push(stack2.pop());
                        sb.append("+\n");
                    }
                    stack1.pop();
                    if(stack1.isEmpty()&&stack2.isEmpty())sb.append("-");
                    else sb.append("-\n");
                }
            }
        }catch(Exception e){
            System.out.println("NO");
            System.exit(0);
        }
        System.out.println(sb);
    }
}
