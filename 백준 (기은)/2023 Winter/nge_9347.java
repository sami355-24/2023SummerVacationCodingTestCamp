import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_9347 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] parent;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 노드 수
            k = Integer.parseInt(st.nextToken()); // 사촌의 수를 구해야 하는 노드의 번호

            if(n == 0) { // 종료
                break;
            }

            arr = new int[n + 1];
            parent = new int[n + 1];

            arr[0] = -1;
            parent[0] = - 1;
            int target = 0;
            int idx = -1;
            
            st = new StringTokenizer(br.readLine());
            
            // 값 입력
            for(int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                if(arr[i] == k) target = i;
                
                if(arr[i] != arr[i - 1] + 1) idx++;

                parent[i] = idx;
            }

            sol(target);
        }

        System.out.print(sb);
    }

    static void sol(int target) {
        int count = 0;

        for(int i = 1; i <= n; i++) {
            if(parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]]) {
                count++;
            }
        }
        
        sb.append(count).append("\n");
    }
}
