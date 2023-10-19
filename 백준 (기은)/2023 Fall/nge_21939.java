import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class nge_21939 {
    static int[] data =  new int[100001];
    static PriorityQueue<Problem> maxQue = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Problem> minQue = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine()); // 문제개수
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()); // 문제번호
            int level = Integer.parseInt(st.nextToken()); // 난이도
            data[idx] = level;
            maxQue.add(new Problem(idx, level));
            minQue.add(new Problem(idx, level));
        }

        int cmdCount = Integer.parseInt(br.readLine());
        sol(cmdCount);

        System.out.print(sb);
    }

    static void sol(int cmdCount) throws IOException{
        for(int i = 0; i < cmdCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken(); // 명령어
            int idx; // 문제번호
            int level; // 난이도

            switch(cmd) {
                case "add" : 
                    idx = Integer.parseInt(st.nextToken());
                    level = Integer.parseInt(st.nextToken());
                    data[idx] = level;
                    maxQue.add(new Problem(idx, level));
                    minQue.add(new Problem(idx, level));
                    break;

                case "solved" :
                    idx = Integer.parseInt(st.nextToken());
                    data[idx] = 0;
                    break;

                default :
                    int chs = Integer.parseInt(st.nextToken());
                    search(chs);
            }
        }
    }

    static void search(int chs) {
        if(chs == 1) {
        //     while(map.getOrDefault(maxQue.peek().idx, -1) == -1) {
        //         maxQue.remove();
        //     }

        //     sb.append(maxQue.peek().idx + "\n");

            while(true) {
                Problem p = maxQue.peek();
                if(data[p.idx] == p.level) {
                    sb.append(p.idx + "\n");
                    break;
                }

                maxQue.poll();
            }
        }

        else {
            // while(map.getOrDefault(minQue.peek().idx, -1) == -1) {
            //     minQue.remove();
            // }

            // sb.append(minQue.peek().idx + "\n");

             while(true) {
                Problem p = minQue.peek();
                if(data[p.idx] == p.level) {
                    sb.append(p.idx + "\n");
                    break;
                }

                minQue.poll();
            }
        }
    }
    
    static class Problem implements Comparable<Problem>{
        int idx;
        int level;

        public Problem(int idx, int level) {
            this.idx = idx;
            this.level = level;
        }

        @Override
        public int compareTo(Problem p1) { // 오름차순
            if(this.level == p1.level) {
                return Integer.compare(this.idx, p1.idx);
            }

            return Integer.compare(this.level, p1.level);
        }
    }
}