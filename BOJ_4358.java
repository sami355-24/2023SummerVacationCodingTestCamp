import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BOJ_4358 {
    public static void main(String[] args) throws IOException{
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int total = 0;
        
        while(true) { // map에 입력값 정보를 추가
            map.put(input, map.getOrDefault(input, 0) + 1);
            total++;

            input = br.readLine();
            if(input == null || input.length() == 0) {
                break;
            }
        }
        
        // 사전순으로 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        // 결과 출력
        for(var key : keySet) {
            double value = (double)map.get(key) / total * 100;
            System.out.println(key + " " + String.format("%.4f", value));
        }
    }
}