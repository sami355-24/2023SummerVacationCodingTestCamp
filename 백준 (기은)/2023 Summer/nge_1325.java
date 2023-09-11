import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class nge_1325 {
    static int N; // 컴퓨터의 개수
    static int M; // 각 컴퓨터 간의 연결관계 개수
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(end).add(start);
        }

        sol();
    }

    static void sol() {
        StringBuilder sb = new StringBuilder();
        int[] result = new int[N + 1];
        int max = 0;

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            count = 0;
            bfs(i);
            result[i] = count;
            max = Math.max(count, max);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == max)
                sb.append(i+" ");
        }

        System.out.println(sb);
    }

    static void bfs(int nodeIndex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(nodeIndex);
        visited[nodeIndex] = true;

        while(!q.isEmpty()) {
            int nextIndex = q.poll();
            
            for(int node : list.get(nextIndex)) {
                if(!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                    count++;
                }
            } 
        }
    }
}