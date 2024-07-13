package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//좌표 정렬하기
public class boj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x,y});
        }
        list.sort((int[] a1, int[] a2)->{
           if (a1[0]-a2[0]!=0){
               return a1[0]-a2[0];
           }else{
               return a1[1]-a2[1];
           }
        });
        list.forEach((int[]a )->{
            System.out.println(a[0] + " " +a[1]);
        });
        br.close();
    }
}
