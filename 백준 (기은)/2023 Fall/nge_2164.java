import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class nge_2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sol(n);
    }

    static void sol(int n) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        while(q.size() > 1) {
            // 1. 제일 위에 있는 카드 제거
            q.poll();

            // 2. 제일 위에 있는 카드를 제일 아래로...
            int top = q.peek();
            q.poll();
            q.add(top);
        }

        System.out.println(q.peek());
    }
}