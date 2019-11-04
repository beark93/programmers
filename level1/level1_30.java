/**
 * level1_30
 */
public class level1_30 {

    public static boolean solution(int x) {
        int sum=0;

        for(int a=x;a>0;a/=10) sum += a%10;

        return (x%sum == 0) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}