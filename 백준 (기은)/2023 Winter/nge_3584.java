import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class nge_3584 {
    static boolean[] visited;
    static List<Integer> list[];
    static int N; // 노드 개수
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for(int j = 1; j <= N; j++) {
                list[j] = new ArrayList<>();
            }

            for(int j = 0; j < N - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                list[v1].add(v2);
                list[v2].add(v1);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int target_v1 = Integer.parseInt(st.nextToken());
            int target_v2 = Integer.parseInt(st.nextToken());

            
        }
    }
}
