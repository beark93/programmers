import java.util.*;

class Level1_4 {
    public static int[] level1_4(int[] array, int[][] commands) {
        int[] answer = {};
        
        for(int[] a:commands) {
            if(a[0]>a[1] || a[1]-a[0]+1<a[2]) {
                return answer;
            }
        }
        
        answer = new int[commands.length];
        
        
        for(int i=0;i<commands.length;i++) {
            int[] subArray = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(subArray);

            answer[i] = subArray[commands[i][2]-1];
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1,3,2,5,6,7,6};
        int[][] command = {{2,5,3},{4,4,1},{1,7,2}};
        int[] answer = level1_4(array,command);

        System.out.println(Arrays.toString(answer));
    }
}