import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        List<Integer> list = new ArrayList<Integer>();

        list.add(arr[0]);
        int comp = 0;

        for(int i = 1; i < alen; i++) {
            comp = list.size() - 1;
            int del_num = 0;

            if(list.get(comp) >= arr[i]) {
                for(int j = comp; j >= 0; j--) {
                    if(list.get(j) >= arr[i]) {
                        del_num = j;
                    }
                }

                list.remove(del_num);
                list.add(del_num, arr[i]);
            }

            else {
                list.add(arr[i]);
            }

            // for(int k = 0; k < list.size(); k++){
            //     System.out.print(list.get(k) + " ");
            // }
            // System.out.println();
        }
        
        int ret = list.size();

        return ret; 
    }
}