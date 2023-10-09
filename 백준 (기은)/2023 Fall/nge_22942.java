import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class nge_22942 {
    static class Circle implements Comparable<Circle> {
        int idx; // 원의 번호
        int dot; // 반지름

        public Circle(int idx, int dot) {
            this.idx = idx;
            this.dot = dot;
        }
        
        @Override
        public int compareTo(Circle o) {
            return this.dot - o.dot;
        }
    }
    
     // 우선순위 큐 삽입 

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 원의 개수
        PriorityQueue<Circle> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) { // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dot = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            pq.add(new Circle(i, dot - r));
            pq.add(new Circle(i, dot + r));
        }

        sol(pq); // 솔루션
    }

    static void sol(PriorityQueue<Circle> pq) {
        Stack<Circle> s = new Stack<>();
        boolean ans = false;

        while(!pq.isEmpty()) {
            Circle cur = pq.poll();

            if(s.empty()) {
                s.push(cur);
            }

            else {
                if(s.peek().idx == cur.idx) s.pop();
                else s.push(cur);
            }
        }

        if(s.isEmpty()) {
            ans = true;
        }
        
        System.out.print(ans ? "YES" : "NO");
    }
}