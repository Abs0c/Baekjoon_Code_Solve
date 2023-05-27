import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer sk;
    public static void main(String[] args) throws IOException {
        sk = new StringTokenizer(br.readLine());
        long a = Long.parseLong(sk.nextToken());
        long b = Long.parseLong(sk.nextToken());
        int cnt = 0;

        boolean[] checkArr = new boolean[10000001];
        Arrays.fill(checkArr, true);// boolean 기본 값은 true이다.
        checkArr[0] = false;
        checkArr[1] = false;
        for (int i = 2; i < (int)Math.sqrt(b) + 1; i++){
            if (checkArr[i] == true){ //값이 처리되지 않은 경우, 즉 기본 값을 갖고 있는 경우에 아래 구문을 실행한다는 if문
                int j = 2;
                while (i * j < (int)Math.sqrt(b) + 1){
                    checkArr[i * j] = false;
                    j += 1;
                }
            }
        }
        for (int i = 2; i < (int)Math.sqrt(b) + 1; i++){
            if (checkArr[i] == false){
                continue;
            }
            long cur = i;
            long tmp = cur;
            while (true){
                if (getSize(cur) + getSize(tmp) >= 16){
                    break;
                }
                if (cur * tmp >= a && cur * tmp <= b){
                    cnt++;
                }
                tmp *= cur;
            }
        }
        System.out.println(cnt);
    }

    public static int getSize(long input){
        String temp = Long.toString(input);
        return temp.length();
    }
}
