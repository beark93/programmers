/**
 * level2_9
 */
import java.util.Stack;

public class level2_9 {

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int length = number.length() - k; //리턴문자열의 총 길이
        int index = 0; // number문자열 검색커서
        char[] num_arr = number.toCharArray(); //반복문 처리를 위한 배열화

        while(length>0) {
            // 각 자리수의 숫자는 이전 자리수 숫자의 다음 위치부터
            // 남은 자리수의 개수를 제외한 숫자 중 가장 큰수
            char max = 0;
            for(int i=index;i<number.length()-(length-1);i++) {
                if(num_arr[i]>max) {
                    max = num_arr[i];
                    index = i+1;
                }
            }
            answer.append(max);
            length--;
        }

        return answer.toString();
    }

    public static String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            // 앞자리부터 큰 수 비교해서 k개만 제외
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                System.out.println(stack.pop());
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(solution2("4177252841",4));
    }
}