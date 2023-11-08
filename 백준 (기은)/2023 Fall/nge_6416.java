import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_6416 {
    static int[] outGraph = new int[100000]; // 나가는 노드목록
    static int[] inGraph = new int[100000]; // 들어오는 노드목록
    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 1; // 테스트 케이스 개수
        
        while(true) {
            String s1 = br.readLine();
            if(s1.contains("-1")) {
                break;
            }

            StringTokenizer st1 = new StringTokenizer(s1, "  ");
            
            while(st1.hasMoreTokens()) {
                String s2 = st1.nextToken();

                if(s2.contains("0")) { // 트리 삽입 종료
                    isTree(k); // 트리인지 아닌지 출력
                    k++;
                    // 초기화
                    inGraph = new int[100000];
                    outGraph = new int[100000];
                }

                StringTokenizer st2 = new StringTokenizer(s2);
                int u = Integer.parseInt(st2.nextToken()); // 나가는 노드
                int v = Integer.parseInt(st2.nextToken()); // 들어오는 노드
                
                outGraph[u] += 1;
                inGraph[v] += 1;
            }
        }
    }

    static void isTree(int k) {
        int rootCnt = 0;
        boolean cond2 = true;
        boolean cond3 = true;

        for(int i = 0; i < 100000; i++) {
            if(outGraph[i] > 0 && inGraph[i] == 0) {
                rootCnt++;

                if(rootCnt > 1) break;
            }

            if(inGraph[i] == 0) {
                cond2 = false;
                break;
            }

            if(inGraph[i] > 1) {
                cond3 = false;
                break;
            }
        }

        if(rootCnt != 1 || cond2 == false || cond3 == false) {
            System.out.println("Case " + k + " " + "is " + "not " + "a " + "tree.");
        }

        else {
            System.out.println("Case " + k + " " + "is " +  "a " + "tree.");
        }
    }
}