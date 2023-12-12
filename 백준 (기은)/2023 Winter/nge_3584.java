import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_3584 {
    static boolean[] visited;
    static int N; // 노드 개수
    static StringBuilder sb = new StringBuilder();
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            parents = new int[N + 1];
            visited = new boolean[N + 1];

            for(int j = 0; j < N - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                parents[v2] = v1;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int target_v1 = Integer.parseInt(st.nextToken());
            int target_v2 = Integer.parseInt(st.nextToken());

            sol(target_v1, target_v2);
        }

        System.out.print(sb);
    }

    static void sol(int t1, int t2) {
        while(t1 > 0) {
            visited[t1] = true;
            t1 = parents[t1];
        }

        while(t2 > 0) {
            if(visited[t2]) {
                sb.append(t2).append("\n");
                break;
            }

            t2 = parents[t2];
        }
    }
}