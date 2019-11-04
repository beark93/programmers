/**
 * level2_5
 */
import java.util.Stack;
public class level2_5 {

    public static int solution(String arrangement) {
        int answer = 0;
        // 현재까지 쌓인 막대기
        int rod = 0;
        // 이전 문자 기억
        int prv = 0;

        // 입력문자를 순서대로 처리
        for(int c : arrangement.getBytes()) {
            // 쇠막대기 시작 or 레이저
            if(c == '(') rod++;
            // 쇠막대기 끝 or 레이저 
            else {
                // 레이저 일 경우 위에서 더한 쇠막대기 수 줄이고 더함
                if(prv == '(') answer += --rod;
                // 쇠 막대기 끝일 경우 1개 더하고 쇠막대기 수 줄이기
                else {
                    answer++;
                    rod--;
                }
            }
            prv = c;
        }
        return answer;
    }

    public static int solution2(String arrangement) {
        int answer = 0;
        // 막대기 stack
        Stack<Integer> stack = new Stack<>();

        // 입력문자를 순서대로 처리
        for(int c : arrangement.getBytes()) {
            // 쇠막대기 시작 or 레이저
            if(c == '(') stack.push(c);
            // 쇠막대기 끝 or 레이저 
            else {
                if(stack.peek() == '(') {
                // 레이저 일 경우 위에서 더한 쇠막대기 수 줄이고 더함
                    stack.pop();
                    answer += stack.size();
                } else {
                // 쇠 막대기 끝일 경우 1개 더하고 쇠막대기 수 줄이기
                    stack.pop();
                    answer += 1;
                }
            }
        }
        return answer;
        
    }

    public static void main(String[] args) {
        System.out.println(solution2("()(((()())(())()))(())"));
    }
}