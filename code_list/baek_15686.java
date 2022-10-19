package code_list;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_15686 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk;
        int n, m;
        sk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(sk.nextToken());
        m = Integer.parseInt(sk.nextToken());
        int[][] arr = new int[n][n];
        int[] chikpos = new int[n*n]; int[] homepos = new int[n*n];
        int chikpospos = 0; int homepospos = 0; int sum = 0;

        for (int i = 0; i < n; i++){
            sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int temp = Integer.parseInt(sk.nextToken());
                arr[i][j] = temp;
                if (temp == 2){
                    chikpos[chikpospos++] = i * n + j;
                }
                else if (temp == 1){
                    homepos[homepospos++] = i * n + j;
                }
            }
        }
        
        while (chikpospos > m){
            int[] minjarr = new int[chikpospos];
            int min = 2501;
            for (int i = 0; i < homepospos; i++){
                int minj = 0;
                int temp = 0;
                int homeposx = homepos[i] / n;
                int homeposy = homepos[i] % n;
                for (int j = 0; j < chikpospos; j++){
                    int chikposx = chikpos[j] / n;
                    int chikposy = chikpos[j] % n;

                    temp = Math.abs(homeposx - chikposx) + Math.abs(homeposy - chikposy);
                    if (temp < min){
                        min = temp;
                        minj = j;
                    }
                }
                minjarr[minj] += 1;       
            }
            int tempminj = 2501;
            int tempmini = 0;
            for (int i = 0; i < chikpospos; i++){
                if (tempminj > minjarr[i]){
                    tempminj = minjarr[i];
                    tempmini = i;
                }
            }
            for (int i = tempmini; i < chikpospos -1; i++){
                chikpos[i] = chikpos[i+1];
            }
            chikpospos -= 1;
        }
        System.out.println(chikpos[0]);
        for (int i = 0; i < homepospos; i++){
            int homeposx = homepos[i] / n;
            int homeposy = homepos[i] % n;
            int min = 2501;
            for (int j = 0; j < chikpospos; j++){
                int chikposx = chikpos[j] / n;
                int chikposy = chikpos[j] % n;
                    
                int temp = Math.abs(homeposx - chikposx) + Math.abs(homeposy - chikposy);
                if (temp < min){
                    min = temp;
                }
            }
            sum += min;
        }
         System.out.println(sum);
         br.close();
    }
}
