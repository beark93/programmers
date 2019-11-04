/**
 * level2_2
 */
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class level2_2 {

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // 선행스킬 큐
        Queue<String> skill_sq = new LinkedList<>();

        // 각 스킬트리별 검증
        for(String skill_tree : skill_trees) {

            // 선행스킬 큐 세팅
            for(String s : skill.split("")) skill_sq.offer(s);
            
            boolean correct = true;

            // 스킬트리 1문자씩 검증
            for(int c : skill_tree.getBytes()) {
                // 선행스킬 목록에 포함된 스킬일 경우 순서검증
                if(skill.indexOf((char)c)>=0) {
                    String a = skill_sq.poll();
                    if(a.indexOf((char)c)<0) {
                        correct = false;
                        break;
                    }
                }
            }
            skill_sq.clear();

            if(correct) answer++;
        }

        return answer;
    }

    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            // 스킬트리에서 선행스킬만 남긴 문자열이 선행스킬 문자열과 같아야 함!
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}