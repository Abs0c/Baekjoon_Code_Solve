import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            long N = Long.parseLong(br.readLine());
            long min = 1; long max = Integer.MAX_VALUE; long answer = 1;

            while (min <= max) {
                long mid = (min + max) / 2;
                long val = mid * (mid + 1) / 2;

                if (val > N) max = mid - 1;
                else {
                    answer = Math.max(mid, answer);
                    min = mid + 1;
                }
            }

            System.out.println(answer);
        }

    }
}