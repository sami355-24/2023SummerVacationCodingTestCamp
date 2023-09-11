import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nge_16938 {
    static int answer = 0; // 정답
    static int N;
    static int L;
    static int R;
    static int X;
    static int[] A;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken()); // 백준의 문제 개수
        L = Integer.parseInt(st.nextToken()); // 문제 난이도 하한선
        R = Integer.parseInt(st.nextToken()); // 문제 난이도 상한선
        X = Integer.parseInt(st.nextToken()); // 가장 쉬운 문제와 어려운 문제의 난이도 차이
        
        A = new int[N]; // 각 문제의 난이도
        
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        sol(0,0,0,Integer.MIN_VALUE,Integer.MAX_VALUE);

        System.out.println(answer);
    }

    static void sol(int idx, int cnt, int sum, int max, int min) {
        if(cnt >= 2) {
            if(sum >= L && sum <= R && max - min >= X) {
                answer++;
            }
        }

        for(int i = idx; i < N; i++) {
            sol(i + 1, cnt + 1, sum + A[i], Math.max(max,A[i]), Math.min(min,A[i]));
        }
    }
}