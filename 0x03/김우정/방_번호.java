import java.util.Scanner;

public class Main {
    private static int getMaxValue(int[] arr){
        int max=arr[0];
        for(int i=1; i<arr.length; i++){
            if(max<arr[i]) max=arr[i];
        }

        return max;
    }
    public static void main(String[] args) {
        //입력
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        //연산
        String result = Integer.toString(num);
        int[] number = new int[9]; //0~8, 9는 6으로 저장.

        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i)=='9'){
                number[6]++;
                continue;
            }
            number[result.charAt(i)-'0']++;
        }

        number[6] = number[6] / 2 + (number[6] % 2);

        //출력
        System.out.println(getMaxValue(number));
    }
}
