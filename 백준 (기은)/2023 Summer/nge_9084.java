import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_9084 {
    static int n; // 동전 가지 수
    static int[] coin; // 동전 종류 + 동전 개수
    static int m; // 동전으로 만들어야 할 금액
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(br.readLine());

            coin = new int[n];
            dp = new int[m + 1];
            dp[0] = 1;

            for(int j = 0; j < n; j++) {
                coin[j] = Integer.parseInt(st.nextToken());  
            }

            sol();

            sb.append(dp[m] + "\n");
        }

        System.out.println(sb);
    }

    static void sol() {
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= m; j++) {
                if(j - coin[i] > 0) {
                    dp[j] += dp[j - coin[i]];
                }

                else if(j - coin[i] == 0) {
                    dp[j] += 1;
                }
            }
        }
    }
}