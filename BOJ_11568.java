import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine()); // 카드의 개수
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 제시한 카드 정보
        int[] arr = new int[count];

        for(int i = 0; i < count; i++) { // 제시한 카드 정보값 받기
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // for(int i = 0; i < count; i++) {
        //     System.out.println(arr[i]);
        // }

        System.out.println(sol(arr,count));
    }

    static int sol(int[] arr, int alen) {
        int max = 0;
        
        for(int i = 0; i < alen; i++) {
            int tmp = 1;
            int comp = i; // 비교 수

            for(int j = i + 1; j < alen; j++) {
                if(arr[j] > arr[comp]) {
                    tmp++;
                    comp = j;
                }
            }

            if(max < tmp) {
                max = tmp;
            }
        }

        return max;      
    }
}