package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N+1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[N] = 1000000000;
        long count =0;
        Stack<Integer> stack = new Stack<>(); //빌딩의 층 수를 저장하는 stack
        Stack<Integer> stack2 = new Stack<>(); //인덱스를 저장하는 stack
        for(int i = N; i>=0; i--){
            while(!stack.isEmpty()&&stack.peek()<arr[i]) {
                stack.pop();
                stack2.pop();
            }
            if(!stack.isEmpty()){
                count+=stack2.peek()-i-1; // 높이가 같거나 높은 index - 현재 Index -1을 count에 더해준다.
            }
            stack.push(arr[i]);
            stack2.push(i);
        }
        System.out.println(count);
    }
}

