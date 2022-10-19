package code_list;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1969{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer sk = null;
        sk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(sk.nextToken());
        int M = Integer.parseInt(sk.nextToken());
        
        String[] arr = new String[N];
        int[] distance = new int[M];
        int[] count;
        char[] ansArr = new char[M];
        int sumdistance = 0;

        for (int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }
        
        for (int j = 0; j < M; j++){
            count = new int[26];
            for (int i = 0; i < N; i++){
                int tt = (int)arr[i].charAt(j);
                tt -= 65;
                count[tt]++;
            }
            int maxi = 0;
            for (int i = 0; i < 26; i++){
                if (count[i] > count[maxi]){
                    maxi = i;
                }
            }
            ansArr[j] = (char)(maxi + 65);
        }
        
        for (int j = 0; j < M; j++){
            for (int i = 0; i < N; i++){
                if (ansArr[j] != arr[i].charAt(j)){
                    distance[j] += 1;
                }
            }
        }
        for (int i = 0; i < M; i++){
            sumdistance += distance[i];
        }
        br.close();

        for (int i = 0; i < M; i++){
            System.out.print(ansArr[i]);
        }
        System.out.println();
        System.out.println(sumdistance);
    }
}