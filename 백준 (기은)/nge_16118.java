import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class nge_16118 {
    static int stumpCnt; // 나무 그루터기 개수
    static int pathCnt; // 오솔길 개수

    static int count = 0;
    static ArrayList<Node>[] graph; // 그래프
    static int distFox[];
    static int distWolf[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        stumpCnt = Integer.parseInt(st.nextToken());
        pathCnt = Integer.parseInt(st.nextToken());
        graph = new ArrayList[stumpCnt + 1];
        for(int i = 1; i <= stumpCnt; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < pathCnt; i++) { // 그루터기와 오솔길 정보 입력
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        sol();

        System.out.println(count);
    }

    static void sol() {
        boolean[] chk = new boolean[stumpCnt + 1];
        distFox = new int[stumpCnt + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(distFox, INF);
        distFox[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if(chk[nowVertex]) continue;
            chk[nowVertex] = true;

            for(Node next : graph[nowVertex]) {
                if(distFox[next.index] > distFox[nowVertex] + next.cost) { // 여우
                    distFox[next.index] = distFox[nowVertex] + next.cost;
                    pq.offer(new Node(next.cost, distFox[next.index]));
                }
            }
        }
    }
}