import java.util.*;

public class Main {
    static int n;
    static int cnt;
    static int[] row;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        row = new int[n];
        cnt = 0;

        recursion(0);
        System.out.println(cnt);
    }

    private static boolean isAdjacent(int x) {
        for (int i = 0; i < x; i++) {
            if (row[x] == row[i] || Math.abs(row[x] - row[i]) == x - i) {
                return false;
            }
        }
        return true;
    }

    private static void recursion(int x) {
        if (x == n) {
            cnt++;
        } else {
            for (int i = 0; i < n; i++) {
                row[x] = i;
                if (isAdjacent(x)) {
                    recursion(x + 1);
                }
            }
        }
    }
}