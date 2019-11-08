public class level1_11 {
    public static boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;

        String replace = s.replaceAll("[^pyPY]","");
        
        if(replace.equals("") || replace.length()%2 != 0) {
            answer = false;
        } else {
            for(int c : replace.getBytes()) {
                if(c >= 'a') {
                    if(c == 'p') p++;
                    else y++;
                } else {
                    if(c == 'P') p++;
                    else y++;
                }
            }
        }
        
        if(p != y) answer = false;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }
}