import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> count = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        List<Integer> keyList = new ArrayList<>(count.keySet());
        Collections.sort(keyList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(count.get(o2), count.get(o1));
            }
        });

        Iterator<Integer> it = keyList.iterator();
        StringBuilder sb = new StringBuilder();

        while(it.hasNext()){
            Integer element = it.next();
            for(int i = 0; i < count.get(element); i++){
                sb.append(element).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
