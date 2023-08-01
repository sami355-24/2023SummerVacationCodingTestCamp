import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_13910 {
    static int[] woks;
    static int max = 10001;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        woks = new int[max];
        dp = new int[n + 1];

        woks[0] = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int chs = Integer.parseInt(st.nextToken());
            woks[chs]++;
        }

        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            dp[i] = max;
        }

        sol(n);
    }

    static void sol(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= i - j; j++) {
                if(j == i - j && woks[j] >= 2) { // 같은 크기의 웍을 사용한 경우
                    dp[i] = 1;
                }

                else if(j != i - j && woks[j] >= 1 && woks[i - j] >= 1) { // 다른 크기의 웍을 2개 사용한 경우
                    dp[i] = 1;
                }

                else if(dp[j] != max && dp[i - j] != max) { // i - j 와 i가 모두 웍에 존재하지 않는 경우
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }        
        }

        if(dp[n] >= max) {
            System.out.println(-1);
        }

        else {
            System.out.println(dp[n]);
        }
    }
}