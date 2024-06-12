package week5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class boj18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int last = -1;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< N; i++){
            String line = br.readLine();
            String[] lines = line.split(" ");
            switch (lines[0]){
                case "push":
                    last =Integer.parseInt(lines[1]);
                    queue.add(last);
                    continue;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else{
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1).append("\n");
                    }
                    else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else{
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else{
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        br.close();
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }
}
