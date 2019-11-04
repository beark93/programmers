import java.util.Arrays;

/**
 * level1_32
 */
public class level1_32 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length/arr1[0].length][arr1[0].length];
        
        for(int i=0;i<answer.length;i++) {
            for(int j=0;j<answer[i].length;j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1,2},{3,4}},new int[][]{{1,2},{3,4}})));
    }
}