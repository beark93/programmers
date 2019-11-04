/**
 * level2_1
 */
import java.util.Queue;
import java.util.LinkedList;

public class level2_1 {
    /**
     * 스스로 푼 해답
     */
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 시간
        int now = 0; // 현재 올라간 트럭들의 무게 합
        int index = 0; // 올라가야할 트럭 번호
        int[] length = new int[truck_weights.length]; // 각 트럭이 이동한 거리

        while(truck_weights.length > index) {
            // 다리를 다 지나간 트럭 확인
            for(int i=0;i<index;i++) {
                if(length[i] == 0) now -= truck_weights[i];
            }
            
            // 다리에 무게에 따라 다음 올라올 트럭 선별
            if(now+truck_weights[index]<=weight) {
                now += truck_weights[index];
                length[index] = bridge_length;
                index++;
            }
            
            // 트럭 이동
            for(int i=0;i<index;i++) {
                length[i]--;
            }
            answer++;
        }

        return answer+bridge_length;
    }

    /**
     * 다른 해답에서 Queue를 사용한 해답
     */

     /**
      * @variable wight : 트럭 무게
      * @variable move : 트럭 이동거리
      *
      * @method moving : 트럭 이동
      */
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution2(int bridgeLength, int weight, int[] truckWeights) {
        // 대기트럭 과 이동트럭 큐 생성
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        // 최초 모든 트럭을 대기트럭 큐에 추가
        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            // 첫 트럭 이동트럭 큐로 추가
            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            // 이동트럭들 이동
            for (Truck t : moveQ) {
                t.moving();
            }

            // 다리를 통과한 트럭 이동트럭 큐에서 제거
            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            // 무게 계산 후 대기트럭에서 이동트럭으로 트럭 이동
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2,10,new int[]{7,4,5,6}));
        System.out.println(solution(100,100,new int[]{10}));
        System.out.println(solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}