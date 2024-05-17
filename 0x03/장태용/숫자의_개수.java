import java.util.Scanner;

public class boj2577 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []arr = new int[10];
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();
        String str = Integer.toString(a*b*c);
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-'0'] += 1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
