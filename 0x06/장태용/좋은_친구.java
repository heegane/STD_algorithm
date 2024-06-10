package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj3078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            for (int j = 0; j < queue.size(); j++) {
                int temp = queue.poll();
                if (temp == name.length()) {
                    answer ++;
                }
                queue.add(temp);
            }
            queue.add(name.length());
            if(queue.size() > K){
                queue.poll();
            }
        }
        System.out.println(answer);
        br.close();
    }
}

