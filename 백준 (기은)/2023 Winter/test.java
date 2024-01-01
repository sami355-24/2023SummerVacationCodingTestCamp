import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int arr[] = {2,2,1,4};
        Arrays.sort(arr);
        
        for (int i : arr) {
            System.out.print("["+i+"]");
        }
    }
}
