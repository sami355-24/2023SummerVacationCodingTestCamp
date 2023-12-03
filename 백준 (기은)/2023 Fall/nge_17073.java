import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class nge_17073 {
    static List<Integer> list[];
    static boolean[] visited;
    static int count = 0; // 리프노드 수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        double W = Double.parseDouble(st.nextToken()); // 물의 양

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<Integer>();          
        }
        
        // 노드 입력
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            
            list[v1].add(v2);
            list[v2].add(v1);
        }

        sol(N);

        System.out.printf("%.10f", W / count);
    }

    static void sol(int N) {
        for(int i = 2; i < N + 1; i++) {
            if(list[i].size() == 1) {
                count++;
            }
        }
    }
}