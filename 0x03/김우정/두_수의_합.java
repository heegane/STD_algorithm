import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //입력
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] arr = new int[num];
        for(int i=0;i<num;i++)
            arr[i]=scanner.nextInt();

        int key = scanner.nextInt();
        scanner.close();

        //연산
        int count=0;
        int left=0;
        int right=arr.length-1;

        Arrays.sort(arr);

        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==key){
                count++;
                left++;
                right--;
            }
            else if(sum>key){
                right--;
            }
            else{
                left++;
            }
        }

        //출력
        System.out.println(count);
    }
}
