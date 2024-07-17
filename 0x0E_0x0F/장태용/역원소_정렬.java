package week10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//역원소 정렬
public class boj5648 {

    static long convert(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String str = sc.next();
            list.add(convert(str));
        }
        list.stream().sorted().forEach(System.out::println);
        sc.close();
    }
}
