채package week3;

import java.io.*;

public class boj1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int []arr1 = new int[26];
        int []arr2 = new int[26];

        for(int i = 0; i <str1.length(); i++) {
            arr1[str1.charAt(i) - 'a']+=1;
        }
        for(int i = 0; i <str2.length(); i++) {
            arr2[str2.charAt(i) - 'a']+=1;
        }
        int result = 0;
        for(int i = 0; i < 26; i++) {
            result += Math.abs(arr1[i]-arr2[i]);
        }
        wr.write(Integer.toString(result));
        wr.close();
        br.close();
    }
}
