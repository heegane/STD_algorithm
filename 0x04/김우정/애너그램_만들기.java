import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = reader.readLine();
        String str2 = reader.readLine();

        int arr[] = new int[26];

        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            arr[str1.charAt(i) - 'a']++;
            arr[str2.charAt(i) - 'a']--;
        }

        for(int i=minLength; i<str1.length();i++) {
            arr[str1.charAt(i) - 'a']++;
        }

        for(int i=minLength; i<str2.length();i++) {
            arr[str2.charAt(i) - 'a']--;
        }

        int result = 0;
        for (int i = 0 ; i < arr.length; i++) {
            result += Math.abs(arr[i]);
        }

        writer.write(String.valueOf(result));
        writer.flush();
        reader.close();
        writer.close();
    }
}
