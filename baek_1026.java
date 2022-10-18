import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1026 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk;

        int n = Integer.parseInt(br.readLine());
        int[] arra = new int[n];
        int[] arrb = new int[n];
        int[] sizeb = new int[n];
        int[] sizebb = new int[n];
        int sum = 0;

        sk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arra[i] = Integer.parseInt(sk.nextToken());
        }
        sk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arrb[i] = Integer.parseInt(sk.nextToken());
        }
        for (int k = 0; k < n-1; k++){
            int mini = k;
            for (int i = k; i < n; i++){
                if (arra[i] < arra[mini]){
                    mini = i;
                }
            }
            int temp = arra[k];
            arra[k] = arra[mini];
            arra[mini] = temp;
        }
        for (int i = 0; i < n; i++){
            int temp = 1;
            for (int j = 0; j < n; j++){
                if (arrb[i] < arrb[j]){
                    temp += 1;
                }
            }
            sizeb[i] = temp;
        }
        for (int i = 0; i < n; i++){
            sizebb[sizeb[i] - 1] = i; // 0번째 값은 4위이다(sizeb[0]) =>4위의 자리에 0번째 값이 있다로 바꿔야함
        }
        
        for (int i = 0; i < n; i++){
            System.out.println(arra[sizebb[i]] + " " + arrb[i]);
            sum += arra[sizebb[i]] * arrb[i];
        }
        System.out.println(sum);
    }
}
