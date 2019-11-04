/**
 * level1_31
 */
public class level1_31 {

    public static String solution(String phone_number) {
        char[] arr = phone_number.toCharArray();

        for(int i=0;i<phone_number.length()-4;i++) arr[i] = '*';

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(solution("01062766370"));
    }
}