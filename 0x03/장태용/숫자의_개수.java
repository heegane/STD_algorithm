import java.io.*;

public class boj2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int []arr = new int[10];
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String str = Integer.toString(a*b*c);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-'0'] += 1;
        }
        for (int i = 0; i < 10; i++) {
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
