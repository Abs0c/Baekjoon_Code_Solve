import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer sk;
    public static Queue<Integer> queue = new LinkedList();
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int backTemp = 0;
        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            String temp = sk.nextToken();
            if (temp.compareTo("push") == 0){
                backTemp = Integer.parseInt(sk.nextToken());
                queue.add(backTemp);
            }
            else if (temp.compareTo("pop") == 0){
                if (queue.size() <= 0){
                    bw.write("-1");
                    bw.newLine();
                }
                else{
                    bw.write(queue.poll()+"");
                    bw.newLine();
                }
            }
            else if (temp.compareTo("size") == 0){
                bw.write(queue.size()+"");
                bw.newLine();
            }
            else if (temp.compareTo("empty") == 0){
                if (queue.isEmpty()){
                    bw.write("1");
                    bw.newLine();
                }
                else{
                    bw.write("0");
                    bw.newLine();
                }
            }
            else if (temp.compareTo("front") == 0){
                if (queue.size() <= 0){
                    bw.write("-1");
                    bw.newLine();
                }
                else{
                    bw.write(queue.peek()+"");
                    bw.newLine();
                }
            }
            else if (temp.compareTo("back") == 0){
                if (queue.size() <= 0){
                    bw.write("-1");
                    bw.newLine();
                }
                else{
                    bw.write(backTemp+"");
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
