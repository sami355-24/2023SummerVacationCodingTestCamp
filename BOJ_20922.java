import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // N
        int K = Integer.parseInt(st.nextToken()); // K
        
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) { // 수열 정보
            arr[i] = Integer.parseInt(st.nextToken());    
        }
        // 여기까지 입력
        
        int ans = 0;
        int start = 0;
        int end = 0;
        int cnt[] = new int[100001];

        while(end < arr.length) {
            while(end < arr.length && cnt[arr[end]] + 1 <= K) {
                cnt[arr[end]]++;
                end++;
            }

            int len = end - start;
            ans = Math.max(ans, len);
            cnt[arr[start]]--;
            start++;
        }

        System.out.println(ans);
    }
}