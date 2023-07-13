import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {
    static int[] countArr;
    static int limit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // N
        int K = Integer.parseInt(st.nextToken()); // K
        
        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N + 1];
        countArr = new int[N + 1];

        for(int i = 0; i < N; i++) { // 수열 정보
            arr[i] = Integer.parseInt(st.nextToken());    
        }
        
        sol(arr, N, K, 0);

        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(answer < countArr[i]) {
                answer = countArr[i];
            }
        }
        
        System.out.println(answer);
    }

    static void sol(int[] arr, int N, int K ,int start) {
        if(N - start + 1 < limit) {
            return;
        }

        int[] chk = new int[100001];
        int count = 0; // 수열의 원소 카운트

        for(int i = 0; i < 100001; i++) {
            chk[i] = 0;
        }

        for(int i = start; i < N; i++) {
            int idx = arr[i];

            if(chk[idx] >= K) {
                break;
            }

            else {
                // System.out.println(idx);
                chk[idx] += 1;
                count++;
            }
        }

        countArr[start] = count;

        if(start == 0) {
            limit = count;
        }

        sol(arr, N, K, start + 1);
    }
}