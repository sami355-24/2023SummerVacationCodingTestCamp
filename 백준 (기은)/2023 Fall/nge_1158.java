import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class nge_1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sol(n,k);
    }

    static void sol(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        int idx = 0;

        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()) {
            idx = (idx + k - 1) % list.size();
            sb.append(list.get(idx) + ", ");
            list.remove(idx);
        }

        sb.deleteCharAt(sb.length() - 2);
        sb.deleteCharAt(sb.length() - 1);
        
        System.out.print("<");
        System.out.print(sb);
        System.out.print(">");
    }
}