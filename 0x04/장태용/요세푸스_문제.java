package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 1; i <= N; i++) {
            al.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        sb.append("<");
        while(al.size() > 0){
            for(int i = 0; i < K-1; i++){
                index = (index + 1) % al.size();
            }
            sb.append(al.get(index));
            al.remove(index);
            if(al.size() > 0){
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
        br.close();
    }
}
