import java.util.Scanner;

public class boj1475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
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
        System.out.println(max);
    }
}
