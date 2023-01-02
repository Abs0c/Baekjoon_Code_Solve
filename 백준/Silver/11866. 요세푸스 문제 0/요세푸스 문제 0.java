import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sk.nextToken());
        int k = Integer.parseInt(sk.nextToken());
        Queue<Integer> inputQueue = new LinkedList<>();
        Queue<Integer> resultQueue = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            inputQueue.add(i);
        }
        while (!inputQueue.isEmpty()){
            for(int i = 0; i < k-1; i++){
                inputQueue.add(inputQueue.poll());
            }
            resultQueue.add(inputQueue.poll());
        }
        System.out.print("<");
        for (int i = 0; i < n-1; i++){
            System.out.print(resultQueue.poll() +", ");
        }
        System.out.println(resultQueue.poll()+">");
    }
}