import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //입력
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        scanner.close();

        //연산
        String result = Integer.toString(num1*num2*num3);
        int[] number = new int[10];

        for(int i = 0; i < result.length(); i++){
            number[result.charAt(i)-'0']++;
        }

        //출력
        StringBuilder output = new StringBuilder();

        for(int i=0; i<number.length; i++){
            output.append(number[i]+"\n");
        }

        System.out.println(output.toString().trim());
    }
}
