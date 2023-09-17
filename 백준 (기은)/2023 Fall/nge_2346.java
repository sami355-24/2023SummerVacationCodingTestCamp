import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class nge_2346 {
    static Deque<int []> d = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int[] input = {i,num};
            d.add(input);
        }

        sol(n);
    }

    static void sol(int n) {
        int[] arr = new int[n]; 
        int count = 0;
        // 처음 값
        int[] in = d.poll();
        arr[count++] = in[0];
        int opC = in[1];

        while(!d.isEmpty()) { 
            if(opC > 0) { // 양수
                for(int i = 1; i < opC; i++) {
                    d.add(d.poll());
                }

                in = d.poll();
                arr[count++] = in[0];
                opC = in[1];
                continue;
            }

            else { // 음수
                for(int i = 1; i < -opC; i++) {
                    d.addFirst(d.pollLast());
                }

                in = d.pollLast();
                arr[count++] = in[0];
                opC = in[1];
                continue;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}