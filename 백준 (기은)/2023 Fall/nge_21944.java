import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nge_21944 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 문제 리스트 안의 문제 개수
        int L; // 난이도
        int G; // 그룹

        for(int i = 0; i < N; i++) { // 문제 리스트 정보 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 문제 리스트의 자료형?? (정하기)
        }
        
    }

    static class Problem { // 문제
        int idx; // 번호
        int G; // 그룹
        int L; // 난이도
        
        public Problem(int idx, int G, int L) {
            this.idx = idx;
            this.G = G;
            this.L = L;
        }
    }
}