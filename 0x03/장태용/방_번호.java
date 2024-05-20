import java.io.*;

public class boj1475 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int []arr = new int[9];
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - '0';
            if (index == 6 || index == 9){
                arr[6] += 1;
            }else{
                arr[index] += 1;
            }
        }
        arr[6] = (int) Math.ceil(arr[6] / 2.0);
        int max = 0;
        for (int j : arr) {
            if (j > max)
                max = j;
        }
        bw.write(Integer.toString(max));
        bw.close();
        br.close();
    }
}
