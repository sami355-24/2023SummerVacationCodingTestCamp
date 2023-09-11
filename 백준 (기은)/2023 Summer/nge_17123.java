import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_17123 {
    static int n; // 2차원 배열의 크기 
    static int m; // 연산의 개수
    static int[][] A;
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine()); // 케이스 개수
        
        for(int i = 0; i < caseCount; i++) {
            /* n, m 값 입력 */
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            A = new int[n + 1][n + 1];

            /* 배열안에 값 입력 */
            for(int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= n; k++) {
                    A[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            /* r1 ~ v 값 입력 */
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                sol(r1,c1,r2,c2,v);
            }

            sum(A);
        }
    }

    static void sol(int r1, int c1, int r2, int c2, int v) {
        for(int i = r1; i <= r2; i++) {
            for(int j = c1; j <= c2; j++) {
                A[i][j] += v;
            }
        }
    }

    static void sum(int[][] arr) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) { // 각 행의 합
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                sum += arr[i][j];
            }
            sb.append(sum + " ");
        }

        System.out.println(sb);

        sb = new StringBuilder();

        for(int i = 1; i <= n; i++) { // 각 열의 합
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                sum += arr[j][i];
            }

            sb.append(sum + " ");
        }

         System.out.println(sb);
    }
}