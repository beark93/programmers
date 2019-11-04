/**
 * level2_3
 */
import java.util.*;

public class level2_3 {

    static class Progress {
        private int work;
        private int speed;
    
        public Progress(int work, int speed) {
            this.work = work;
            this.speed = speed;
        }

        public void working() {
            this.work += this.speed;
        }

        public int getWork() {
            return this.work;
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        // 작업 큐 선언
        Queue<Progress> qu_Progresses = new LinkedList<>();
        // 종료 큐 선언
        Queue<Integer> qu_end = new LinkedList<>();

        // 모든 작업을 작어 큐에 추가
        for(int i=0;i<progresses.length;i++) {
            qu_Progresses.offer(new Progress(progresses[i],speeds[i]));
        }
        

        while(!qu_Progresses.isEmpty()) {
            int end = 0;

            // 최선두 작업이 종료되었을 경우 연속적으로 작업이 완료된 작업 종료
            while(!qu_Progresses.isEmpty() && qu_Progresses.peek().getWork() > 100) {
                qu_Progresses.remove();
                end++;
            }
            
            // 종료된 작업이 있을경우 종료 큐에 갯수 입력
            if(end!=0) qu_end.offer(end);
            
            // 작업큐 내 작업 진행
            for(Progress p : qu_Progresses) {
                p.working();
            }
        }

        int[] answer = new int[qu_end.size()];
        for(int i=0;i<answer.length;i++) answer[i] = qu_end.poll();

        return answer;

    }

    /**
     * 작업을 순차적으로 끝날때까지 진행시키고
     * 그 시간을 기억하여 이 후 업무들이 그 시간에 끝나면 같이 변수로 저장
     * 안 끝난 업무 발생시 다시 진행하는 것을 반복
     */
    public static int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution2(new int[]{93,30,55}, new int[]{1,30,5})));
    }
}