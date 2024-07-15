import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Set<String> set = new HashSet<>(Arrays.asList(words));
        String[] uniqueWords = set.toArray(new String[0]);

        Arrays.sort(uniqueWords, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() - b.length();
            }
        });

        for (String word : uniqueWords) {
            sb.append(word + "\n");
        }
        System.out.println(sb);
    }
}