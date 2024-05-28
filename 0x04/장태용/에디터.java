package week3;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class boj1406 {
    public static void main(String[] args) throws IOException {
        LinkedList<Character> al = new LinkedList<Character>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            al.add(str.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());
        ListIterator<Character> it = al.listIterator(al.size());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("P")){
                Character temp = st.nextToken().charAt(0);
                it.add(temp);
            }else if(command.equals("L")){
                if(it.hasPrevious()){
                    it.previous();
                }
            }else if(command.equals("D")){
                if(it.hasNext()){
                    it.next();
                }
            }else{
                if(it.hasPrevious()){
                    it.previous();
                    it.remove();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : al) {
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
