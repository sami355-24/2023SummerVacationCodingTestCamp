import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int endIndex;
    long time;
    boolean isFasted;
    int state; // 뭐지??

    Node(int endIndex, long time) {
        this.endIndex = endIndex;
        this.time = time;
    }

    Node(int endIndex, long time, int state) {
        this.endIndex = endIndex;
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Node o) {
        if(this.time < o.time) {
            return -1;
        }

        else {
            return 1;
        }
    }
}

public class nge_16118 {
    static List<Node>[] graph;
    static long[] foxTime;
    static long[][] wolfTime;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        wolfTime = new long[2][n + 1];
        foxTime = new long[n + 1];

        Arrays.fill(foxTime, Long.MAX_VALUE);
        Arrays.fill(wolfTime[0], Long.MAX_VALUE);
        Arrays.fill(wolfTime[1], Long.MAX_VALUE);

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < m; i++) { // 그루터기와 오솔길 정보 입력
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken()) * 2;

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        solFox();
        solWolf();        

        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(foxTime[i] < Math.min(wolfTime[0][i], wolfTime[1][i])) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void solFox() {
        Queue<Node> queue = new PriorityQueue<Node>();
        queue.offer(new Node(1,0));
        foxTime[1] = 0; // 다익스트라 시작시점 초기화

        while(!queue.isEmpty()) {
            Node nowVertex = queue.poll();

            if(foxTime[nowVertex.endIndex] < nowVertex.time) {
                continue;
            }

            for(Node v : graph[nowVertex.endIndex]) {
                long cost = foxTime[nowVertex.endIndex] + v.time;
                if(cost < foxTime[v.endIndex]) {
                    foxTime[v.endIndex] = cost;
                    queue.offer(new Node(v.endIndex, cost));
                }
            }
        }
    }

    static void solWolf() {
        Queue<Node> queue = new PriorityQueue<Node>();
        queue.offer(new Node(1,0,0));
        wolfTime[0][1] = 0;

        while(!queue.isEmpty()) {
            Node nowVertex = queue.poll();
            int end = nowVertex.endIndex;
            long nowTime = nowVertex.time;

            if(wolfTime[nowVertex.state][end] < nowTime) {
                continue;
            }

            for(Node v : graph[end]) {
                int state = 1 - nowVertex.state;
                long cost = wolfTime[nowVertex.state][end] + ((nowVertex.state == 0) ? v.time / 2 : v.time * 2);

                if(wolfTime[state][v.endIndex] > cost) {
                    wolfTime[state][v.endIndex] = cost;
                    queue.offer(new Node(v.endIndex, cost, state));
                }
            }
        }
    }
}