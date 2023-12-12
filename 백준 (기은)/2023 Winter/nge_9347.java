import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class nge_9347 {
    static ArrayList<Node>[] list;
    static HashMap<Integer, Integer> map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 노드 수
            int k = Integer.parseInt(st.nextToken()); // 사촌의 수를 구해야 하는 노드의 번호

            if(n == 0) {
                break;
            }

            arr = new int[n + 1];
            int idx = 1;
            list = new ArrayList[n + 1];

            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());    
            }

            // 초기 루트 위치와 연속된 정수 위치 
            int root = 1;
            int t = 2;
            int depth = 1;

            // 트리 생성
            while(t <= idx) {
                map.put(depth, arr[t]);

                if(arr[t] == arr[t + 1]) {
                    t++;
                }
                
                else {
                    depth++;
                }
            }

            for(int i = 1; i <= depth; i++) {
                map.get
            }

            sol(arr[root]);
        }
    }

    static void sol(int root) {
        // BFS를 통해 구하고자
    }

    static class Node {
        int idx;
        int depth;

        public Node(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }
}
