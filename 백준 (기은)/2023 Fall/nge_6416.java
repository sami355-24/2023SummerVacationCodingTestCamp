import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class nge_6416 {
    static HashMap<Integer, Integer> from = new HashMap<>(); // 나가는 정점
    static HashSet<Integer> to = new HashSet<>(); // 들어오는 정점

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        out :
        for(int k = 1; ; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean flag = false; // 트리의 여부

            while(true) {
                if(!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }

                int u = Integer.parseInt(st.nextToken()); // 나가는 정점
                int v = Integer.parseInt(st.nextToken()); // 들어오는 정점
                
                if(u == 0) {
                    isTree(flag, k); // 트리인지 확인

                    // 초기화
                    from = new HashMap<>();
                    to = new HashSet<>();
                    break;
                }

                if(u == -1) {
                    break out; // 프로그램 종료
                }

                if(to.add(v) == false) { // hashset에 이미 도착 정점이 존재하는 경우 (즉, 한 정점에 두 개의 정점이 이어진 경우)
                    flag = true;
                }
                
                from.put(u, from.getOrDefault(v, 0) + 1); // 키 : 정점의 개수 값 : 키의 정점과 이어진 정점의 개수
            }
        }

        System.out.print(sb);
    }

    static void isTree(boolean flag, int k) { // 트리 확인 함수
        if(to.size() == 0) { // 정점이 아예 없는 경우
            sb.append("Case " + k + " " + "is " +  "a " + "tree.").append("\n");
            return;
        }

        int rootCnt = 0;

        for(int key : from.keySet()) { // 시작 정점을 모두 뽑아내고
            if(!to.contains(key)) { // 그 정점이 도착 정점들과 비교 후 같은 정점이 없다면 이는 루트노드가 된다
                rootCnt++;
            }
        }

        if(rootCnt != 1) { // 루트노드가 하나 밖에 없는 경우 이는 트리 조건을 만족할 수 없다.
            flag = true;
        }

        if(flag) {
            sb.append("Case " + k + " " + "is " + "not " + "a " + "tree.").append("\n");
        }

        else {
            sb.append("Case " + k + " " + "is " +  "a " + "tree.").append("\n");
        }
    }
}