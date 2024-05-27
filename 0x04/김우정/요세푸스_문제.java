import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        StringBuilder result = new StringBuilder();

        result.append("<");
        int index=0;
        while (!list.isEmpty()) {
            index = (index + k - 1) % list.size();
            result.append(list.remove(index));
            if (!list.isEmpty()) {
                result.append(", ");
            }
        }

        result.append(">");
        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}
