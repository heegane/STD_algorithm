import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Pair> dp = new ArrayList<>();

            // dp 초기화
            dp.add(new Pair(1, 0)); // dp[0]
            dp.add(new Pair(0, 1)); // dp[1]

            for (int j = 2; j <= n; j++) {
                int cntZero = dp.get(j - 2).cntZero + dp.get(j - 1).cntZero;
                int cntOne = dp.get(j - 2).cntOne + dp.get(j - 1).cntOne;
                dp.add(new Pair(cntZero, cntOne));
            }

            System.out.printf("%d %d\n", dp.get(n).cntZero, dp.get(n).cntOne);
        }
        br.close();
    }

    static class Pair {
        int cntZero;
        int cntOne;

        public Pair(int cntZero, int cntOne) {
            this.cntZero = cntZero;
            this.cntOne = cntOne;
        }
    }
}

