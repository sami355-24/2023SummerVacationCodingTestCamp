import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nge_20924 {
    static int N; // 노드개수
    static ArrayList<Node>[] nodeList; // 트리정보
    static int postLength = 0; // 기둥의 길이
    static int max_Branch_Length = 0; // 최대 가지의 길이 
    static boolean[] visited;
    static int gigaIdx;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken()); // 루트노드의 번호

        nodeList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodeList[v1].add(new Node(v2, e));
            nodeList[v2].add(new Node(v1, e));
        }

        visited = new boolean[N + 1];
        gigaIdx = N; // 마지막 노드로 초기화

        if(nodeList[root].size() > 1) {
            gigaIdx = root;
        }

        else {
            findPost(root); // 기가노드 찾기 + 기둥의 길이를 구한다.
        }

        findMax(gigaIdx, 0);

        System.out.print(postLength + " " + max_Branch_Length);
    }

    static void findPost(int root) {
       visited[root] = true; 
       if(nodeList[root].size() > 2) {
            gigaIdx = root;
            return;
       }

        for(Node n : nodeList[root]) {
            if(!visited[n.num]) {
                postLength += n.cost;
                findPost(n.num);
            }
        }
    }

    static void findMax(int n, int length) {
        visited[n] = true;

        if(nodeList[n].size() < 2) {
            max_Branch_Length = Math.max(max_Branch_Length, length);
            return;
        }

        for(Node i : nodeList[n]) {
            if(!visited[i.num]) {
                findMax(i.num, length + i.cost);
            }
        }
    }

    static class Node {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}