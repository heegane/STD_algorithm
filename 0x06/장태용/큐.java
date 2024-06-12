package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int last = -1;
        for(int i = 0; i< N; i++){
            String line = br.readLine();
            String[] lines = line.split(" ");
            switch (lines[0]){
                case "push":
                    last =Integer.parseInt(lines[1]);
                    queue.add(last);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(queue.poll());
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        System.out.println(1);
                    }
                    else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(queue.peek());
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(last);
                    }
                    break;
            }
        }
        br.close();
    }
}
