/**
 * level2_8
 */
import java.util.*;

public class level2_8 {

    public static int solution(int[] priorities, int location) {
        Queue<Integer> pri_qu = new LinkedList<>(); // 우선순위 큐
        Queue<Integer> loc_qu = new LinkedList<>(); // 요청문서 큐

        for(int i=0;i<priorities.length;i++) {
            if(i == location) loc_qu.offer(1);
            else loc_qu.offer(0);

            pri_qu.offer(priorities[i]);
        }

        int cnt=0;

        while(true) {
            int pri = pri_qu.poll();
            int loc = loc_qu.poll();
            boolean print = true;

            // 남은 문서들중 우선순위가 높은 문서가 있다면 print값 false
            for(int c : pri_qu) {
                if(c>pri) {
                    print=false;
                    break;
                }
            }

            if(!print) {
            // print 하지 않으면 다시 큐에 추가
                pri_qu.offer(pri);
                loc_qu.offer(loc);
            } else {
            // print 하면 프린트 순서 카운팅
                cnt++;
            // 해당 문서가 요청 문서일 경우 종료
                if(loc == 1) break;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2},2));
    }
}