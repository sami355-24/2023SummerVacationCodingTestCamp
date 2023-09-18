import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class nge_1874 {
    static int[] arr;
    static int[] cond;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        cond = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            cond[i] = i + 1;
        }

        sol(n);
    }

    static void sol(int n) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        int pCount = 0;

        s.push(cond[pCount++]);
        sb.append("+\n");
        
        while(s.isEmpty() || s.peek() != arr[0]) {
            s.push(cond[pCount++]);
            sb.append("+\n");
        }

        int save = arr[0];
        s.pop();
        sb.append("-\n");

        for(int i = 1; i < n; i++) {
            if(save < arr[i]) {
                while(s.isEmpty() || s.peek() != arr[i]) {
                    s.push(cond[pCount++]);
                    sb.append("+\n");
                }

                save = arr[i];
                s.pop();
                sb.append("-\n");
            }

            else {
                if(s.peek() == arr[i]) {
                    sb.append("-\n");
                    s.pop();
                }

                else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.print(sb);
    }
}