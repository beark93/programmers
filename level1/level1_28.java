/**
 * level1_28
 */
public class level1_28 {

    public static int solution(int num) {
        long n = num;
        int cnt;

        for(cnt=0;cnt<=500&&n!=1;cnt++) {
            if(n%2 == 0) n /= 2;
            else n = n*3+1;
        }

        return (n==1) ? cnt : -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(626331));
    }
}