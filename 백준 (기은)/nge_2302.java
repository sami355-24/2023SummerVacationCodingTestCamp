import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class nge_2302 {
    static int n;
    static List<Integer> list = new ArrayList<Integer>();
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 좌석의 개수
        int m = Integer.parseInt(br.readLine()); // 고정석의 개수
        
        for(int i = 0; i < m; i++) {
            int fix = Integer.parseInt(br.readLine());
            list.add(fix);
        }

        dp = new int[n + 1];

        System.out.println(sol());
    }

    static int sol() {
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            if(list.contains(i) || list.contains(i - 1)) {
                dp[i] = dp[i - 1];
            }

            else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        
        return dp[n];
    }
}