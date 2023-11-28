import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_14675 {
    static boolean graph[][]; // 그래프
    static int N; // 정점 개수
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 정점개수
        graph = new boolean[N + 1][N + 1];

        for(int i = 1; i <= N - 1; i++) { // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }

        int q = Integer.parseInt(br.readLine());

        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t =  Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sol(t,k);
        }

        System.out.print(sb);
    }

    static void sol(int t, int k) {
        boolean tmp[][] = graph;
        int ev; // 제외할 정점

        if(t == 1) { // 정점 제거
            for(int i = 1; i <= N; i++) {
                tmp[k][i] = false;
                tmp[i][k] = false;
            }
            ev = k;
        }

        else { // 간선 제거
            int v1 = k;
            int v2 = k + 1;

            tmp[v1][v2] = false;
            tmp[v2][v1] = false;

            ev = 0;
        }

        // 트리체크
        for(int i = 1; i <= N; i++) {
            if(i == ev) { // 없어진 정점이라면 건너뛰기
                continue;
            }

            visited = new boolean[N + 1];
            DFS(tmp,i);
            
            boolean chk = isTree(ev);
    
            if(chk) {
                sb.append("no").append("\n");
                return;
            }

            else {
                continue;
            }
        }

        sb.append("yes").append("\n");
    }

    static void DFS(boolean[][] tmp, int v) {
        visited[v] = true;

        for(int i = 1; i <= N; i++) {
            if(!visited[i] && tmp[v][i] == true) {
                DFS(tmp, i);
            }
        }
    }

    static boolean isTree(int ev) {
        for(int i = 1; i <= N; i++) {
            if(i == ev) {
                continue;
            }

            if(visited[i] == false) {
                return false;
            }
        }
        return true;
    }
}