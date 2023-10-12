import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class nge_4358 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        HashMap<String, Double> map = new HashMap<>();
        double count = 0; // 개체수

         // 1. 해시맵에 정보등록
        while((input = br.readLine()) != null) {
            if(map.get(input) != null) { // 이미 값이 존재하는 경우
                double val = map.get(input);
                map.put(input, val + 1);
            }

            else { // 처음 값을 넣는 경우
                map.put(input, 1.0);
            }

            count++;

        }

        // 2. HashMap 사전 순으로 나열
        Map<String, Double> sortedMap = new TreeMap<>(map);

        // 3. 출력
        for(String s : sortedMap.keySet()) {
            double ratio = sortedMap.get(s) / count;

            System.out.println(s + " " + String.format("%.4f", ratio * 100));
        }
    }
}