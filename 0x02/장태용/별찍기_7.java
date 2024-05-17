import java.util.Scanner;

public class boj2444 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = 0; j < n-i-1; j++){
                str += " ";
            }
            for(int j = 0; j < 2*i+1; j++){
                str += "*";
            }
            System.out.println(str);
        }
        for(int i = n-1; i > 0; i--){
            String str = "";
            for(int j = 0; j < n-i; j++){
                str += " ";
            }
            for(int j = 0; j < 2*i-1; j++){
                str += "*";
            }
            System.out.println(str);
        }

    }
}
