import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nge_4358 {
    public static void main(String[] args) throws IOException{
        Map<String, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int total = 0;
        
        while(true) { // map�� �Է°� ������ �߰�
            map.put(input, map.getOrDefault(input, 0) + 1);
            total++;

            input = br.readLine();
            if(input == null || input.length() == 0) {
                break;
            }
        }
        
        // ���������� ����
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        // ��� ���
        for(var key : keySet) {
            double value = (double)map.get(key) / total * 100;
            System.out.println(key + " " + String.format("%.4f", value));
        }
    }
}