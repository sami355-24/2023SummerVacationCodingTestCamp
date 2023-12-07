import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class nge_1967 {
    static List<Node> list[];
    static boolean[] visited;
    static int N; // 노드 개수
    static int max = 0;
    static int chk;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[v1].add(new Node(v2, e));
            list[v2].add(new Node(v1, e));
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            chk = i;
            sol(i, 0);
        }

        System.out.print(max);
    }
    
    static void sol(int root, int length) {
        visited[root] = true;

        if(list[root].size() == 1 && root != chk) {
            max = Math.max(max, length);
            return;
        }

        for(Node n : list[root]) {
            if(!visited[n.idx]) {
                sol(n.idx, length + n.cost);
            }
        }
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}