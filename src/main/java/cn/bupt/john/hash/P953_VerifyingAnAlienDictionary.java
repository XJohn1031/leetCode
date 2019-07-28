package cn.bupt.john.hash;

/**
 * O(N^2)遍历
 */
public class P953_VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        P953_VerifyingAnAlienDictionary solution = new P953_VerifyingAnAlienDictionary();
        System.out.println(solution.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length -1; i++) {
            for (int j = i; j < words.length; j++) {
                char[] charI = words[i].toCharArray();
                char[] charJ = words[j].toCharArray();
                for (int k = 0; k < charI.length; k++) {
                    if (k >= charJ.length || order.indexOf(String.valueOf(charI[k])) > order.indexOf(String.valueOf(charJ[k]))) {
                        return false;
                    }
                    if (order.indexOf(String.valueOf(charI[k])) < order.indexOf(String.valueOf(charJ[k]))) {
                        break;
                    }
                }
            }
        }
        return true;
    }
}
