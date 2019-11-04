/**
 * level1_35
 */
import java.util.Arrays;

public class level1_35 {

    public static int solution(int[] d, int budget) {
        int answer = 0;

        int sum = 0;
        Arrays.sort(d);

        for(int i=0;i<d.length;i++) {
            sum += d[i];

            if(sum>budget) break;
            else answer = i+1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{11},10));
    }
}