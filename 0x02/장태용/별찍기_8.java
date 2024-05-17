import java.util.Scanner;

public class boj2445 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = 0; j < i+1; j++){
                str += "*";
            }
            for(int j = i+1; j < 2*n-i-1; j++){
                str += " ";
            }

            for(int j = 2*n-i-1; j < 2*n; j++){
                str += "*";
            }
            System.out.println(str);
        }
        for(int i = n-2; i >= 0; i--){
            String str = "";
            for(int j = 0; j < i+1; j++){
                str += "*";
            }
            for(int j = i+1; j < 2*n-i-1; j++){
                str += " ";
            }

            for(int j = 2*n-i-1; j < 2*n; j++){
                str += "*";
            }
            System.out.println(str);
        }
    }

}
