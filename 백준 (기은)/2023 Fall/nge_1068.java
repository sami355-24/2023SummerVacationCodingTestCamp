import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class nge_1068 {
    static List<Integer> list[];
    static int root = 0;
    static int N; // 노드의 개수
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine()); // 데이터 입력
        for(int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());

            if(idx == -1) {
                root = i;
                continue;
            }

            list[idx].add(i);
        }

        int del = Integer.parseInt(br.readLine());

        if(root == del) {
            System.out.print(count);
            return;
        }
        
        sol(root, del);

        System.out.print(count);
    }

    static void sol(int v, int del) {
        if(list[v].contains(del)) {
            list[v].remove(Integer.valueOf(del));
        }

        if(list[v].size() == 0) {
            count++;
            return;
        }
        
        for(int node : list[v]) {
            sol(node, del);
        }
    }
}