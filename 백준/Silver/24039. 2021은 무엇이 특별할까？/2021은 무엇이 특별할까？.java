import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    // N이 10000까지 이고, 예시의 2021은 두 소수 43과 47의 곱이며, 2021의 다음 수는 2491이고, 2491은 두 소수 47과 53의 곱이다.
    // 즉 문제에서 원하는 주어진 수보다 큰 특별한 수 중 가장 작은 수는
    // 해당 조건을 만족하고, 연속된 두 소수의 곱을 말한다.
    // 이를 이용하여 에라토스테네스의 체 알고리즘을 사용하여 1 부터 주어진 수까지의 소수를 구하고,
    // 두 연속된 소수를 곱하는걸 반복해서 주어진 수보다 커지는 순간 break한다
    // 그리고 그 커진 수를 출력한다.
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] checkPrime = new boolean[n+1]; 
        Arrays.fill(checkPrime, true); //기본값은 true임
        for (int i = 2; i < (int)Math.sqrt(n)+1; i++){
            if (checkPrime[i] == true){
                int j = 2;
                while(i * j <= n){
                    checkPrime[i * j] = false;
                    j += 1;
                }
            }
        }

        ArrayList<Integer> primeNumberArray = new ArrayList<>();
        for (int i = 2; i < n+1; i++){
            if (checkPrime[i]){
                primeNumberArray.add(i);
            }
        }

        int result = 6; //n이 1이랑 2인 경우에도 출력값은 6이므로 기본값을 6으로 설정해둔다.
        //2보다 큰 수의 경우에는 정상적으로 알고리즘이 굴러가므로 1, 2만 기본값에 따라서 결과가 출력된다.
        for (int i = 0; i < primeNumberArray.size()-1; i++){
            int a = primeNumberArray.get(i);
            int b = primeNumberArray.get(i+1);
            if (n < a * b){
                result = a * b;
                break;
            }
        }
        System.out.println(result);
    }
}