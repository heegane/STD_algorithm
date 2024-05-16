import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int num = scanner.nextInt();
        StringBuilder str = new StringBuilder();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++){
            int a = scanner.nextInt();
            if(a < num){
                str.append(a).append(" ");
            }
        }

        scanner.close();
        System.out.println(str);




    }
}