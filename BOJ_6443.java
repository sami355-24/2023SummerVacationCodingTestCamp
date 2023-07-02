import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class BOJ_6443 {
    static HashSet<String> hashSet;
    static List<String> list;

    static void permutation(int arr[], String word, int depth, int wordLength) {
        if(depth == wordLength) {
            String s = "";
            int index = 0;
            char c;

            for(int i = 0; i < wordLength; i++) {
                index = arr[i] - 1;
                c = word.charAt(index);
                s = s + c;
            }

            hashSet.add(s);
            return;
        }

        for(int i = depth; i < wordLength; i++) {
            swap(arr, depth, i);
            permutation(arr, word, depth + 1, wordLength);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(br.readLine());
        String word;

        for(int i = 0; i < wordCount; i++) {
            hashSet = new HashSet<String>(); // HashSet 선언
            word = br.readLine();
            int wordLength = word.length(); // 문자 길이

            int[] arr = new int[wordLength + 1];

            for(int j = 0; j < wordLength; j++) {
                arr[j] = j + 1;
            }

            // 순열
            permutation(arr, word,0, word.length());
            
            list = new ArrayList<String>(hashSet);
            list.sort(Comparator.naturalOrder());
            
            for(String s : list) {
                System.out.println(s);
            }
        }
    }
}