import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase=Integer.parseInt(reader.readLine());

        for(int i=0;i<testCase;i++){
            String str=reader.readLine();
            LinkedList<Character> list = new LinkedList<>();

            ListIterator<Character> listIterator=list.listIterator();

            for(char ch:str.toCharArray()) {
                switch (ch) {
                    case '<':
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        break;
                    case '>':
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        break;
                    case '-':
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                            listIterator.remove();
                        }
                        break;
                    default:
                        listIterator.add(ch);
                        break;
                }
            }

            StringBuilder builder = new StringBuilder();
            for(char ch : list){
                builder.append(ch);
            }

            writer.write(builder.toString());
            writer.newLine();
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
