import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_12845{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer sk = null;
        int N = Integer.parseInt(br.readLine());
        sk = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        int maxi = 0;
        int sum = 0;
        int deli = 0;

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(sk.nextToken());
            if (arr[i] > arr[maxi]){
                maxi = i;
            }
        }

        while (N > 1){
            if (maxi > 0 & maxi < N - 1){
                if (arr[maxi-1] > arr[maxi+1]){
                    sum += arr[maxi] + arr[maxi-1];
                    deli = maxi - 1;
                    maxi -= 1;
                }
                else{
                    sum += arr[maxi] + arr[maxi+1];
                    deli = maxi + 1;
                }
            }
            else if (maxi > 0){
                sum += arr[maxi] + arr[maxi-1];
                deli = maxi - 1;
                maxi -= 1;
            }
            else if (maxi < N - 1){
                sum += arr[maxi] + arr[maxi+1];
                deli = maxi + 1;
            }
            else{
                break;
            }
            
            for (int i = deli; i < N - 1; i++){
                arr[i] = arr[i+1];
            }
            N = N - 1;
        }
        System.out.println(sum);
        br.close();
    }
}

