import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class nge_14675 {
    static List<Integer> list[];
    static int N; // 정점 개수
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 정점개수
        list = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) { // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        int q = Integer.parseInt(br.readLine());

        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t =  Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sol(t,k);
        }

        System.out.print(sb);
    }

    static void sol(int t, int k) {
        if(t == 2) {
            sb.append("yes").append("\n");
        }

        else {
            if(list[k].size() >= 2) {
                sb.append("yes").append("\n");
            }

            else {
                sb.append("no").append("\n");
            }
        }
    }
}
