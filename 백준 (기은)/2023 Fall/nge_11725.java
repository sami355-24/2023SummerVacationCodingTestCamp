import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class nge_11725 {
    static int[] parent;
    static boolean[] isVisit;
    static List<Integer> list[];
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int nCount = Integer.parseInt(br.readLine()); // 노드의 개수
        parent = new int[nCount + 1];
        isVisit = new boolean[nCount + 1];
        list = new ArrayList[nCount + 1];

        for(int i = 0; i <= nCount; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < nCount - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        sol(1);

        for(int i = 2; i <= nCount; i++) { // 정답 출력
            System.out.println(parent[i]);
        }
    }

    static void sol(int idx) {
        isVisit[idx] = true;

        for(int e : list[idx]) {
            if(!isVisit[e]) {
                parent[e] = idx;
                sol(e);
            }
        }
    }
}