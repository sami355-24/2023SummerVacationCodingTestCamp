import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_13422 {
    static int n; // 집의 개수
    static int m; // 도둑이 돈을 훔칠 연속된 집의 개수
    static int k; // 자동 방범 장치가 작동하는 최소 돈의 양
    static long[] arr;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < tCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new long[n + 1];
            
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }

            sol();
            System.out.println(count);
        }
    }

    static void sol() {
        long sum = 0;
        count = 0;

        // 처음
        for(int i = 0; i < m; i++) {
            sum += arr[i];
        }

        if(sum < k) {
            count++;
        }


        if(n == m) { // 만약 집의 개수와 도둑이 돈을 훔칠 연속된 집의 개수 바로 return 해준다.
            return;
        }

        int turn = 1;

        while(turn < n) {
            int index = (turn + m - 1) % n;
            sum += arr[index];
            sum -= arr[turn - 1];

            if(sum < k) {
                count++;
            }

            turn++;
        }
    }
}