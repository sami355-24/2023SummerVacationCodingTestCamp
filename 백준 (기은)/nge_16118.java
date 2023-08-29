import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int index;
    double cost;

    public Node(int index, double cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.cost, o.cost);
    }
}

class NodeWolf implements Comparable<NodeWolf> {
    int index;
    double cost;
    Boolean isRest;

    public NodeWolf(int index, double cost, boolean isRest) {
        this.index = index;
        this.cost = cost;
        this.isRest = isRest;
    }

    @Override
    public int compareTo(NodeWolf o) {
        return Double.compare(this.cost, o.cost);
    }
}

public class nge_16118 {
    static int stumpCnt; // 나무 그루터기 개수
    static int pathCnt; // 오솔길 개수

    static int count = 0;
    static ArrayList<Node>[] graph; // 그래프
    static double distFox[];
    static double distWolf[];

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
            // graph[w].add(new Node(v, cost));
        }

        sol();

        for(int i = 1; i <= stumpCnt; i++) {
            if(distFox[i] < distWolf[i]) {
                System.out.println(distWolf[i]);
            }
        }

        System.out.println(count);
    }

    static void sol() {
        boolean[] chk = new boolean[stumpCnt + 1];
        distFox = new double[stumpCnt + 1];
        double INF = Double.MAX_VALUE;

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
                    pq.offer(new Node(next.index, distFox[next.index]));
                }
            }
        }

        PriorityQueue<NodeWolf> pqW = new PriorityQueue<>();
        pqW.offer(new NodeWolf(1,0, false));

        chk = new boolean[stumpCnt + 1];
        distWolf = new double[stumpCnt + 1];
        Arrays.fill(distWolf, INF);
        distWolf[1] = 0;
        boolean isRest;

        while(!pqW.isEmpty()) {
            NodeWolf now = pqW.poll();
            int nowVertex = now.index;
            isRest = now.isRest;

            if(chk[nowVertex]) continue;
            chk[nowVertex] = true;

            for(Node next : graph[nowVertex]) {
                if(isRest == false) {
                    if(distWolf[next.index] > distWolf[nowVertex] + next.cost / 2.0) { // 여우
                        distWolf[next.index] = distWolf[nowVertex] + next.cost / 2.0;
                        pqW.offer(new NodeWolf(next.index, distWolf[next.index], true));
                    }
                }

                else {
                     if(distWolf[next.index] > distWolf[nowVertex] + next.cost * 2.0) { // 여우
                        distWolf[next.index] = distWolf[nowVertex] + next.cost * 2.0;
                        pqW.offer(new NodeWolf(next.index, distWolf[next.index], false));
                    }
                }
            }
        }
    }
}