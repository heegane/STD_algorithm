package week3;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class boj5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            LinkedList<Character> ll = new LinkedList<>();
            ListIterator<Character> it = ll.listIterator();
            for(int j = 0; j < str.length(); j++) {
                Character temp = str.charAt(j);
                if(temp.equals('<')) {
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                }else if(temp.equals('>')) {
                    if(it.hasNext()) {
                        it.next();
                    }
                }else if(temp.equals('-')){
                    if(it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                }
                else{
                    it.add(temp);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : ll) {
                sb.append(c);
            }
            System.out.println(sb.toString());
            br.close();
        }
    }
}
