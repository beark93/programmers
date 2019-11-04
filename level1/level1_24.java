/**
 * level1_24
 */
public class level1_24 {

    public static long solution(long n) {
        long answer = 0;

        double sqrt = Math.sqrt((double)n);

        if(sqrt == Math.round(sqrt)) answer = ((int)sqrt+1)*((int)sqrt+1);
        else answer = -1;

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(10000));
    }
}