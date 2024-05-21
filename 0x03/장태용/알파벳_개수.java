import java.io.*;

public class boj10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int []arr = new int[26]; // a~z
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
