import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        HashMap<Integer, Integer> map = new LinkedHashMap<>(); // 순서를 저장할 수 있는 해시 맵

        for (String inputData : br.readLine().split(" ")) {
            int num = Integer.parseInt(inputData);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(map.get(b), map.get(a));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            for (int i = 0; i < map.get(num); i++) {
                sb.append(num + " ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}