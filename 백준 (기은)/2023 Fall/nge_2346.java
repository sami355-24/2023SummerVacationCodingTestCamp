import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class nge_2346 {
    static List<int[]> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int[] input = {i,num};
            list.add(input);
        }

        sol(n);
    }

    static void sol(int n) {
        int[] arr = new int[n];
        int idx = 0;
        int count = 0;
        
        while(!list.isEmpty()) {
            int removeIdx = idx % list.size();

            arr[count++] = list.get(removeIdx)[0];
            // arr[count++] = idx;
            idx += list.get(removeIdx)[1];

            if(removeIdx < list.size() - 1) {
                // System.out.println("지남");
                idx -= 1; 
            }

            if(idx < 0) {
                idx += list.size();
            }

            list.remove(removeIdx);
        }

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // for(int i = 0; i < n; i++) {
        //     System.out.print(list.get(i)[0] + " ");
        // }
    }
}