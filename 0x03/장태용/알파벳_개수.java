import java.util.Scanner;

public class boj10808 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []arr = new int[26]; // a~z
        String str = scanner.next();
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
        scanner.close();
    }
}
