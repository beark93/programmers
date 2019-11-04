/**
 * level1_25
 */
import java.util.Arrays;
public class level1_25 {

    public static int[] solution(int[] arr) {
        int[] answer;
        if(arr.length == 1) {
            answer = new int[]{-1};
        } else {
            answer = new int[arr.length-1];
            int idx = 0;
            for(int i=1;i<arr.length;i++) {
                if(arr[i]<arr[idx]) idx=i;
            }
            for(int i=0;i<arr.length;i++) {
                if(i < idx) answer[i] = arr[i]; 
                else if(i > idx) answer[i-1] = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] test1 = {4,1,3,2};
        int[] test2 = {10};
        System.out.println(Arrays.toString(solution(test1)));
        System.out.println(Arrays.toString(solution(test2)));
    }
}