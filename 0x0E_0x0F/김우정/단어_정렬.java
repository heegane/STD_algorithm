import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> stringSet = new HashSet<>();
        for(int i=0; i<n; i++){
            stringSet.add(br.readLine());
        }

        String[] strings = stringSet.toArray(new String[0]);

        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                if(str1.length()!=str2.length()){
                    return Integer.compare(str1.length(), str2.length());
                } else {
                    return str1.compareTo(str2);
                }
            }
        });

        for(String str:strings){
            System.out.println(str);
        }
    }
}
