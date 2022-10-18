import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek_2751 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] cntarr = new int[2000001];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            cntarr[arr[i]+1000000] += 1;
        }
        for (int i = 0; i < 2000001; i++){
            for (int j = 0; j < cntarr[i]; j++){
                bw.write((i-1000000)+"\n");
            }
        }
        br.close();
        bw.close();
    }
}
