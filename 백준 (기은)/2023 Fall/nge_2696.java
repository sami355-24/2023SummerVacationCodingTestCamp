import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class nge_2696 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine()); // 수열의 크기
            sol(M);
        }

        System.out.print(sb);
    }

    static void sol(int M) throws IOException{
        StringTokenizer st = null;
        List<Integer> list = new ArrayList<>();
        String tmp = "";
        int count = 0;

        for(int i = 0; i < M; i++) {
            if(i % 10 == 0) {
                st = new StringTokenizer(br.readLine());
            }

            int num = Integer.parseInt(st.nextToken());

            if((i + 1) % 2 == 0) {
                list.add(num);
            }

            else {
                count++;
                int mid = (i + 1) / 2;
                list.add(num);
                Collections.sort(list);

                tmp += list.get(mid);
                tmp += " ";

                if(count % 10 == 0) {
                    tmp += "\n";
                }
            }
        }

        sb.append(count + "\n");
        sb.append(tmp + "\n");
    }
}