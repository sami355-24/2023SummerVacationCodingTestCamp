import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class nge_21942 {
    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int N, L, F; // 정보의 개수, 대여기간, 벌금
        // StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N = Integer.parseInt(st.nextToken());
        // L = 
        // F = Integer.parseInt(st.nextToken());
        try
    	{
    		// SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    		
    		// // 비교할 시간 (문자열) 
    		// String timeStr1 = "06:50";
    		// String timeStr2 = "12:10";
    		
    		// // 문자열 -> Date 
    		// Date date1 = sdf.parse(timeStr1);
    		// Date date2 = sdf.parse(timeStr2);
			
    		// // Date -> 밀리세컨즈 
    		// long timeMil1 = date1.getTime();
    		// long timeMil2 = date2.getTime();
			
    		// // 비교 
    		// long diff = timeMil2 - timeMil1;
			
    		// long diffSec = diff / 1000;
    		// long diffMin = diff / (1000 * 60);
			
    		// System.out.println("시간 차이(초) : " + diffSec + "초");
    		// System.out.println("시간 차이(분) : " + diffMin + "분");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("DDD/hh:mm");

            String L = "010/00:00";
            String dataDate1 = "2021-01-01";
            String dataDate2 = "2021-01-13";

            Date date1 = sdf.parse(dataDate1);
            Date date2 = sdf.parse(dataDate2);
            Date date3 = sdf2.parse(L);

            long timeMil1 = date1.getTime();
            long timeMil2 = date2.getTime();

            long diff = timeMil2 - timeMil1;
            
            long timeMil3 = date3.getTime();

            if(diff > timeMil3) {
                long gap = diff - timeMil3; // (시간 단위)
                long day = gap / (1000 * 60 * 60 * 12);
                System.out.println(day);
            }

     	}
    	catch (ParseException e)
    	{
			e.printStackTrace();
		}
    	
	}
}
