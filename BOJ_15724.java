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

        // ������ �������
        int N = Integer.parseInt(territory_size[0]);
        int M = Integer.parseInt(territory_size[1]);

        // ��ü����
        int[][] territory = new int[N + 1][M + 1];

        // ���亰 �α��� �� �ֱ�
        for(int i = 1; i <= N; i++) {
            String[] values = br.readLine().split(" ");

            for(int j = 1; j <= M; j++) {
                int value = Integer.parseInt(values[j - 1]);
                territory[i][j] = value;
            }
        }

        int countToWanted = Integer.parseInt(br.readLine()); // ���� �˾Ƴ����� �ϴ� ���簢���� ��
        int[] answer = new int[countToWanted]; // ���簢���� �α���

        int unitCol; // ���� ��
        int unitRow; // ���� ��

        int squareCol; // �˰� ���� ���簢���� ��
        int squareRow; // �˰� ���� ���簢���� ��

        for(int i = 0; i < countToWanted; i++) {
            String[] info = br.readLine().split(" ");
            // �������
            unitRow = Integer.parseInt(info[0]);
            unitCol = Integer.parseInt(info[1]);

            // ���簢�����
            squareRow = Integer.parseInt(info[2]);
            squareCol = Integer.parseInt(info[3]);

            answer[i] = squareSum(unitCol, unitRow, squareCol, squareRow, territory);
        }

        // �������
        for(int i = 0;  i < countToWanted; i++) {
            System.out.println(answer[i]);
        }
    }
}