/**
 * level1_29
 */
public class level1_29 {

    public static double solution(int[] arr) {
        double answer = 0;
        for(int i=0;i<arr.length;i++) answer += (double)arr[i]/arr.length;
        return answer;
    }
        
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,5}));
    }
}