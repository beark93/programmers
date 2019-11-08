import java.util.*;

public class level1_12 {
  public static String solution(String s) {
      String answer = "";
      String[] array = new String[s.length()];
      int index = 0;
      for(int c : s.getBytes()) {
        array[index] = "" + (char)c;
        index++;
      }

      Arrays.sort(array,Comparator.reverseOrder());
      
      for(int i=0;i<array.length;i++) answer += array[i];
      
      return answer;
  }
  public static void main(String[] args) {
      System.out.println(solution("avs"));
  }
}