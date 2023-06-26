import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15724 {

    static int squareSum(int unitCol, int unitRow, int squareCol, int squareRow, int[][] territory) {
        int sum = 0;

        for(int i = 1; i <= squareRow; i++) {
            for(int j = 1; j <= squareCol; j++) {
                sum += territory[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] territory_size = br.readLine().split(" ");

        // 영토의 행렬정보
        int N = Integer.parseInt(territory_size[0]);
        int M = Integer.parseInt(territory_size[1]);

        // 전체영토
        int[][] territory = new int[N + 1][M + 1];

        // 영토별 인구수 값 넣기
        for(int i = 1; i <= N; i++) {
            String[] values = br.readLine().split(" ");

            for(int j = 1; j <= M; j++) {
                int value = Integer.parseInt(values[j - 1]);
                territory[i][j] = value;
            }
        }

        int countToWanted = Integer.parseInt(br.readLine()); // 왕이 알아내고자 하는 직사각형의 수
        int[] answer = new int[countToWanted]; // 직사각형의 인구수

        int unitCol; // 단위 열
        int unitRow; // 단위 행

        int squareCol; // 알고 싶은 직사각형의 열
        int squareRow; // 알고 싶은 직사각형의 행

        for(int i = 0; i < countToWanted; i++) {
            String[] info = br.readLine().split(" ");
            // 단위행렬
            unitRow = Integer.parseInt(info[0]);
            unitCol = Integer.parseInt(info[1]);

            // 직사각형행렬
            squareRow = Integer.parseInt(info[2]);
            squareCol = Integer.parseInt(info[3]);

            answer[i] = squareSum(unitCol, unitRow, squareCol, squareRow, territory);
        }

        // 정답출력
        for(int i = 0;  i < countToWanted; i++) {
            System.out.println(answer[i]);
        }
    }
}