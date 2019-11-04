/**
 * level2_4
 */

public class level2_4 {

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        // 0,1,2 ==> 1,2,4 로 매칭
        int[] num = {1,2,4};
        // 1->0, 2->1, ...
        n -= 1;

        for(int i=1;n>=0;i*=3) {
            // 각 자리수의 총 갯수는 그 총 갯수가 3의 n제곱
            // 각 자리수의 숫자는 이전까지 자리수의 총 개수마다 1씩 증가
            // 11,12,14 -> 21,22,24 -> 41,42,44
            answer.append(num[(n/i)%3]);

            // 실제 3진법과 다르게 앞 자리수의 숫자 앞에 0이 없는 경우가 존재
            // 따라서 앞자리수의 총 개수만큼 현재수를 빼주어서 상위 자리수를 구해야합니다.
            // ex) 실 3진법-> 00,01,02,10,11,12,20,21,22
            //     124나라 -> 1,2,4,11,12,14,21,22,24,41,42,44
            n -= (i*3);
        }
        answer.reverse();
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(40));
    }
}