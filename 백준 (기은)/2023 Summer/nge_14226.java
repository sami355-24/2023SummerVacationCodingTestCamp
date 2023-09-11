import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class nge_14226 {
    static class Node {
    int curClip;
    int curScreen;
    int curTime;

    public Node(int curClip, int curScreen, int curTime) {
            this.curClip = curClip;
            this.curScreen = curScreen;
            this.curTime = curTime;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine()); // 만들고 싶은 이모티콘 갯수
        sol(s);
    }

    static void sol(int s) {
        boolean[][] visited = new boolean[1001][1001];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,1,0));
        visited[0][1] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.curScreen == s) {
                System.out.println(cur.curTime);
                break;
            }

            // 1. 클립보드 저장
            q.offer(new Node(cur.curScreen, cur.curScreen, cur.curTime + 1));

            // 2. 붙여넣기
            if(cur.curClip > 0 && cur.curClip + cur.curScreen <= s && !visited[cur.curClip][cur.curScreen + cur.curClip]) {
                int total = cur.curClip + cur.curScreen;
                q.offer(new Node(cur.curClip, total, cur.curTime + 1));
                visited[cur.curClip][total] = true;
            }

            // 3. 하나 삭제
            if(cur.curScreen > 0 && !visited[cur.curClip][cur.curScreen - 1]) {
                q.offer(new Node(cur.curClip, cur.curScreen - 1, cur.curTime + 1));
                visited[cur.curClip][cur.curScreen - 1] = true;
            }
        }
    }
}