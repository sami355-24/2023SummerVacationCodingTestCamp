import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class nge_9934 {
    static List<Integer> list = new ArrayList<>(); // 저장소
    static StringBuilder sb = new StringBuilder();
    static List<Integer> ans[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = new ArrayList[K + 1];

        while(st.hasMoreTokens()) {
           list.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i <= K; i++) {
            ans[i] = new ArrayList<>();
        }

        sol(0, list.size() - 1, 1);

        for(int i = 1; i <= K; i++) {
            for(int key : ans[i]) {
                System.out.print(key + " ");
            }

            System.out.println();
        }
    }

    static void sol(int left, int right, int lv) {
        if(left == right) {
            ans[lv].add(list.get(left));
            return;
        }

        int mid = (left + right) / 2;
        ans[lv].add(list.get(mid));

        sol(left, mid - 1, lv + 1);
        sol(mid + 1, right, lv + 1);
    }
}
