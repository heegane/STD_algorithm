import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        StringBuilder output = new StringBuilder();

        for(int row=0; row<2*n-1; row++)
        {
            int spaces = Math.abs(n-row-1);
            int stars = 2*(n-spaces)-1;

            for(int space = 0; space < spaces; space++)
                output.append(" ");

            for(int star = 0; star < stars; star++)
                output.append("*");
            output.append("\n");
        }

        System.out.println(output.toString());
    }
}
