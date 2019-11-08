import java.util.StringTokenizer;

public class level1_20 {
  public static String solution(String s) {
      String answer = "";
      
      StringTokenizer st = new StringTokenizer(s);
      /*
      for(String str : st.nextToken()) {
          for(int i=0;i<str.length();i++) {
              if(i%2 == 0) c[i] = Character.toLowerCase(c[i]);
              answer += c[i];
          }
          
          answer += " ";
      }
      */
      
      return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution("try hello world"));
  }
}