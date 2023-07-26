import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int Qcount = Integer.parseInt(br.readLine());        
        int slen = s.length();
        int[][] sum = new int[slen][26];

        sum[0][s.charAt(0) - 'a']++;

        for(int i = 1; i < slen; i++) {
            int tmp = s.charAt(i) - 'a';
            
            for(int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j];
            }

            sum[i][tmp]++;
        }

        StringBuilder sb = new StringBuilder(); // 이거떄매 50점...?
        for(int i = 0; i < Qcount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char at = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start == 0) {
                sb.append(sum[end][at - 'a']).append('\n');
            }

            else {
                sb.append(sum[end][at - 'a'] - sum[start - 1][at - 'a']).append('\n');
            }
        }
        System.out.println(sb);
    }
}