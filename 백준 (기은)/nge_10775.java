import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class nge_10775 {
    static int[] plane; // 비행기 배열
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        int g; // 게이트의 수
        int p; // 비행기의 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine()); 
        plane = new int[p];

        for(int i = 0; i < p; i++) {
            plane[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= g; i++) {
            s.push(i);
        }

        sol(g,p);
    }

    static void sol(int g, int p) {
        int count = 0;
        Stack<Integer> tmp = new Stack<>();

        for(int i = 0; i < p; i++) {
            boolean chk = false;

            while(!s.isEmpty()) {
                if(s.peek() <= plane[i]) {
                    s.pop();
                    count++;

                    while(!tmp.isEmpty()) {
                        s.push(tmp.peek());
                        tmp.pop();
                    }

                    chk = true;
                    break;
                }

                else {
                    tmp.push(s.peek());
                    s.pop();
                }
            }

            if(!chk) {
                break;
            }
        }

        System.out.println(count);
    }
}