import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16938 {
    static int answer = 0; // 정답
    static int N;
    static int L;
    static int R;
    static int X;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken()); // 백준의 문제 개수
        L = Integer.parseInt(st.nextToken()); // 문제 난이도 하한선
        R = Integer.parseInt(st.nextToken()); // 문제 난이도 상한선
        X = Integer.parseInt(st.nextToken()); // 가장 쉬운 문제와 어려운 문제의 난이도 차이

        int[] A = new int[N]; // 각 문제의 난이도
        
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 방법

        /* 전체 경우의 수 2개 이하의 집합을 순열 후 조건에 일치하는지 확인
         * 만약에 일치한다면 이거 카운트하기
         */
        boolean[] visited = new boolean[N];
        powerSet(A ,visited ,N ,0);

        System.out.println(answer);
    }

    static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
        if (idx == n) {
            checkConditon(arr, visited, n);
            return;
        }

        visited[idx] = false;
        powerSet(arr, visited, n, idx + 1);

        visited[idx] = true;
        powerSet(arr, visited, n, idx + 1);
    }

    static void checkConditon(int[] arr, boolean[] visited, int n) {
        int[] c = new int[n];
        int count = 0;
        int sumLevel = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i] == true) {
                c[count++] = arr[i];
                sumLevel += arr[i];
            }
        }

        if(count < 2) {
            return;
        }

        Arrays.sort(c);

        int easiestPlusHardest = c[0] + c[count - 1];

        if(sumLevel >= L && sumLevel <= R) {
            if(easiestPlusHardest >= X) {
                answer++;
            }
        }
    }
}