import java.util.Scanner;

public class boj2446 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = 0; j < i; j++){
                str += " ";
            }
            for(int j = i; j < 2*n-i-1; j++){
                str += "*";
            }
            System.out.println(str);
        }
        for(int i = n-2; i >= 0; i--){
            String str = "";
            for(int j = 0; j < i; j++){
                str += " ";
            }
            for(int j = i; j < 2*n-i-1; j++){
                str += "*";
            }
            System.out.println(str);
        }
    }

}
