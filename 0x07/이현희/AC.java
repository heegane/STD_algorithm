import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            char direction = 'L';
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> q = new ArrayDeque<>();
            String inputLine = br.readLine();
            if (n > 0) {
                String[] inputData = inputLine.replace("[", "").replace("]", "").split(",");
                for (int j = 0; j < n; j++) {
                    q.add(Integer.parseInt(inputData[j].trim()));
                }
            }

            boolean error = false;
            for (String command : p) {
                switch (command) {
                    case "R":
                        direction = (direction == 'L') ? 'R' : 'L';
                        break;
                    case "D":
                        if (q.isEmpty()) {
                            error = true;
                            break;
                        }
                        if (direction == 'L') {
                            q.pollFirst();
                        } else {
                            q.pollLast();
                        }
                        break;
                }
                if (error) {
                    break;
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (!q.isEmpty()) {
                    if (direction == 'L') {
                        while (q.size() > 1) {
                            sb.append(q.pollFirst() + ",");
                        }
                        sb.append(q.pollFirst());
                    } else {
                        while (q.size() > 1) {
                            sb.append(q.pollLast() + ",");
                        }
                        sb.append(q.pollLast());
                    }
                }
                sb.append("]\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
