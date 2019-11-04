/**
 * level2_7
 */
import java.util.*;

public class level2_7 {

    public static int[] solution(int[] heights) {
        Stack<Integer> st = new Stack<>();
        
        int[] answer = new int[heights.length];

        for(int i=0;i<heights.length;i++) {
            st.push(heights[i]);
            answer[i] = i; // 각 탑의 index를 넣어준다
        }

        while(st.size()>1) {
            int now = st.pop(); // 오른쪽 끝 탑 높이

            // 꺼낸 탑 왼쪽탑을 순서대로 확인해서 낮으면 -1
            for(int i=st.size()-1;i>=0;i--) {
                if(heights[i]<=now) answer[st.size()]--;
                else break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,5,3,6,7,6,5})));
    }
}