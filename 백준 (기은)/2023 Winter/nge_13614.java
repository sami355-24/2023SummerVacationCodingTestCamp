import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nge_13614 {
    static int[] arr;
    static int[] diff;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 원생의 수
        arr = new int[N];
        int K = Integer.parseInt(st.nextToken()); // 조의 개수

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sol(N, K);
    }

    static void sol(int N, int K) {
        diff = new int[N - 1];
        int ret = 0;

        for(int i = 0; i < N - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff);

        
        for(int i = 0; i < (N - 1) - (K - 1); i++) {
            ret += diff[i];
        }

        System.out.print(ret);
    }
}