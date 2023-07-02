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
            // 문자열 위치 바꾸기
            return;
        }

        for(int i = depth; i < wordLength; i++) {
            swap(arr , depth , i);
            permutation(arr, word, depth + 1, wordLength);
            swap(arr,depth,i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void print(int[] arr, int r) {
        for(int i = 0; i < r; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(br.readLine()); // 단어 개수
        String word;

        for(int i = 0; i < wordCount; i++) {
            hashSet = new HashSet<String>();
            word = br.readLine();
            int wordLength = word.length();

            int[] arr = new int[wordLength + 1];

            for(int j = 0; j < wordLength; j++) {
                arr[j] = j + 1;
            }

            // 순열
            permutation(arr, 0 , word.length());
            // 순열
            
            list = new ArrayList<String>(hashSet);
            list.sort(Comparator.naturalOrder());
            System.out.println(list);
        }
    }
}