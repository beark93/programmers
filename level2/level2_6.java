/**
 * level2_6
 */
import java.util.*;

public class level2_6 {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> qu= new LinkedList<>();

        // 시간순서대로 큐에 추가
        for(int i=0;i<prices.length;i++) qu.offer(prices[i]);
        int index=0;

        // 시간순서대로 꺼내서 남은 큐에서 처음으로 떨어지는 시점을 확인
        while(!qu.isEmpty()) {
            int n = qu.poll();
            int cnt=0;

            for(int x : qu) {
                cnt++;
                if(x<n) break;
            }

            answer[index++] = cnt;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,2,3})));
    }
}