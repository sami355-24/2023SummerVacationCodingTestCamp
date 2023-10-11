import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class nge_11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 높은 수가 우선순위를 가질 수 있도록 (Collections.reverseOrder 사용)
        int N = Integer.parseInt(br.readLine()); // 연산 수
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            int ans = 0;
            
            if(input == 0) {
                if(!pq.isEmpty()) {
                    ans = pq.poll();
                }

                sb.append(ans + "\n");
            }

            else {
                pq.add(input);
            }
        }

        System.out.println(sb);
    }
}