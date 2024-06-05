
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    // 백준 2562 B3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받음
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int temp = 0;
        int index = 0;
        int cnt = 0;

        for(int i=0; i<9; i++) {
            cnt++;
            if(arr[i]>temp) {
                temp = arr[i];
                index = cnt;
            }
        }
        System.out.println(temp);
        System.out.println(index);

    }
}