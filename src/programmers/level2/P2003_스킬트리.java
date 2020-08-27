package programmers.level2;


public class P2003_스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int result = 0;

        for (String skillTree : skill_trees) {
            String skillClone = skillTree;

            for (int i = 0; i < skillTree.length(); i++) {
                String oneSkill = String.valueOf(skillTree.charAt(i));

                if (!skill.contains(oneSkill)) {
                    skillClone = skillClone.replace(oneSkill, "");
                }
            }
            if (skill.indexOf(skillClone)==0){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
