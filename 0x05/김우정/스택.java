import java.io.*;
import java.util.StringTokenizer;

class Node
{
    int value;
    Node next;

    Node(int value)
    {
        this.value = value;
        this.next = null;
    }
}

class Stack
{
    private Node top;
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public void push(int value)
    {
        Node node = new Node(value);
        node.next = top;
        top = node;
        size++;
    }

    public void pop()
    {
        if(top==null)
        {
            System.out.print(-1+"\n");
            return;
        }
        int tmp = top.value;
        top = top.next;
        size--;

        System.out.print(tmp+"\n");
    }

    public int size()
    {
        System.out.print(size+"\n");
        return size;
    }

    public int empty()
    {
        int result = size==0?1:0;
        System.out.print(result+"\n");
        return result;
    }

    public int top()
    {
        int result = size==0?-1:top.value;
        System.out.print(result+"\n");
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack stack = new Stack();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < num ; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;
                case "pop" :
                    stack.pop();
                    break;
                case "size" :
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top" :
                    stack.top();
                    break;
                default:
                    bw.write("Error!");
            }
        }

        br.close();
        bw.close();
    }
}
