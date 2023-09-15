import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class nge_1935 {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String exp = br.readLine();
        arr = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sol(n,exp);
    }

    static void sol(int n, String exp) {
        Stack<Double> s = new Stack<>();
        double ans = 0;
        
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if(c >= 65 && c <= 90) {
                double input = arr[c - 64];
                s.push(input);
            }

            else if(c == '+') {
                double tmp1 = s.peek();
                s.pop();

                double tmp2 = s.peek();
                s.pop();

                s.push(tmp2 + tmp1);
            }

            else if(c == '-') { 
                double tmp1 = s.peek();
                s.pop();

                double tmp2 = s.peek();
                s.pop();

                s.push(tmp2 - tmp1);
            }

            else if(c == '*') {
                double tmp1 = s.peek();
                s.pop();

                double tmp2 = s.peek();
                s.pop();

                s.push(tmp2 * tmp1);
            }

            else if(c == '/') {
                double tmp1 = s.peek();
                s.pop();

                double tmp2 = s.peek();
                s.pop();

                s.push(tmp2 / tmp1);
            }
        }

        ans = s.peek();
        System.out.printf("%.2f",ans);
    }
}