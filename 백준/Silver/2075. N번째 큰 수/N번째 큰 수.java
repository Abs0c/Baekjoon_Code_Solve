import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer sk;
    public static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            while(sk.hasMoreTokens()){
                queue.add(Integer.parseInt(sk.nextToken()));
            }
        }

        for (int i = 0; i < queue.size(); i++){
            if (i == n-1){
                System.out.println(queue.poll());
            }
            else{
                queue.poll();
            }
        }
    }
}
