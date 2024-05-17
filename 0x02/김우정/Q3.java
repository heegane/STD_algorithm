import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        StringBuilder output = new StringBuilder();
        StringBuilder line = new StringBuilder();

        for (int row = 0; row < 2 * n - 1; row++) {
            line.setLength(0);

            int spaces = 2*Math.abs(n-row-1);
            int stars = n-spaces/2;

            for(int star=0; star<stars;star++)
                line.append("*");
            for(int space=0; space<spaces;space++)
                line.append(" ");
            for(int star=0; star<stars;star++)
                line.append("*");

            output.append(line).append("\n");
        }

        System.out.println(output.toString());
    }
}
