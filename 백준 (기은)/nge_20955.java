import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nge_20955 {
    static int n; // 뉴런 개수
    static int m; // 시냅스 개수
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        Arrays.fill(parents, -1);

        int count = 0;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(!union(u,v)) count++;
        }

        for(int i = 1; i <= n; i++) {
            if(parents[i] < 0) {
                count++;
            }
        } // 그룹 개수 구하기

        System.out.println(count - 1); // 그룹 개수 - 1 = 간선의 개수
    }

    static int find(int n) {
        if(parents[n] < 0) {
            return n;
        }

        else {
            return parents[n] = find(parents[n]);
        }
    }

    static Boolean union(int u, int v) {
        int a = find(u);
        int b = find(v);

        if(a == b) {
            return false;
        }

        int h = parents[a] < parents[b] ? a : b;
        int l = parents[a] < parents[b] ? b : a;
        parents[l] = h;
        return true;
    }
}