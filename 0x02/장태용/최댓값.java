import java.util.Scanner;

public class boj2562 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < 9; i++){
            int num = scanner.nextInt();
            if(max < num){
                max = num;
                maxIndex = i+1;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
    }
}
