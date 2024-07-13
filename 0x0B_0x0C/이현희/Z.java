import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        System.out.println(recursion(n, r, c));

    }

    private static int recursion(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        int half = 1 << (n - 1);
        if (r < half && c < half) {
            return recursion(n - 1, r, c);
        }
        if (r < half && c >= half) {
            return half * half + recursion(n - 1, r, c - half);
        }
        if (r >= half && c < half) {
            return 2 * half * half + recursion(n - 1, r - half, c);
        }
        return 3 * half * half + recursion(n - 1, r - half, c - half);
    }
}