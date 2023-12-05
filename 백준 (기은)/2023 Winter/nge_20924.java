import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_20924 {
    static int N; // 노드개수
    static int[][] graph; // 트리정보
    static int postLength = 0; // 기둥의 길이
    static int max_Branch_Length = 0; // 최대 가지의 길이 
    static boolean[] visited;
    static int[] branchCnt;
    static int gigaIdx;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken()); // 루트노드의 번호
        graph = new int[N + 1][N + 1];
        branchCnt = new int[N + 1];

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[v1][v2] = e;
            graph[v2][v1] = e;

            branchCnt[v1]++;
            branchCnt[v2]++;
        }

        visited = new boolean[N + 1];
        gigaIdx = N; // 마지막 노드로 초기화

        if(branchCnt[root] > 2) {
            gigaIdx = root;
        }

        else {
            findPost(root); // 기가노드 찾기 + 기둥의 길이를 구한다.
        }

        findMax(gigaIdx, 0);

        System.out.print(postLength + " " + max_Branch_Length);
    }

    static void findPost(int root) {
       if(branchCnt[root] > 3) {
            gigaIdx = root;
            return;
       }

        visited[root] = true;

        for(int i = 1; i <= N; i++) {
            if(!visited[i] && graph[root][i] != 0) {
                postLength += graph[root][i];
                findPost(i);
            }
        }
    }

    static void findMax(int n, int length) {
        if(branchCnt[n] <= 2) {
            if(length > max_Branch_Length) {
                max_Branch_Length = length;
            }

            return;
        }

        for(int i = gigaIdx + 1; i <= N; i++) {
            if(!visited[i] && graph[n][i] != 0) {
                findMax(i, length + graph[n][i]);
            }
        }
    }
}