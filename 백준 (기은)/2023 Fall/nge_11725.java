import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class nge_11725 {
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        // 트리 문제
        int nCount = Integer.parseInt(br.readLine()); // 노드의 개수
        sol(nCount);
    }

    static void sol(int nCount) throws IOException {
        map.put(1, 1);

        for(int i = 0; i < nCount - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            search(v1, v2);
        }

        for(int i = 2; i <= nCount; i++) {
            System.out.println(map.get(i));
        }
    }

    static void search(int v1, int v2) {
        if(map.getOrDefault(v1, null) != null) {
            map.put(v2, v1);
        }

        else {
            map.put(v1, v2);
        }
    }
}