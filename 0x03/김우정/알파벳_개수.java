import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //입력
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        //연산
        int[] alphabet = new int[26];

        for(int i = 0; i < str.length(); i++){
            alphabet[str.charAt(i)-'a']++;
        }

        //출력
        StringBuilder output = new StringBuilder();

        for(int i=0; i<alphabet.length; i++){
            output.append(alphabet[i]+" ");
        }

        System.out.println(output.toString().trim());
    }
}
