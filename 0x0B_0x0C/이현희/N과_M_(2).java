import java.util.*;

public class Main {
    static int n;
    static int m;
    static Deque<Integer> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        q = new ArrayDeque<>();
        recursion(1);
    }

    private static void recursion(int start) {
        if (q.size() == m) {
            for (Integer number : q) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!q.contains(i)) {
                q.addLast(i);
                recursion(i + 1);
                q.removeLast();
            }
        }
    }
}