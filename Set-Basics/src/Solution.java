import java.util.TreeSet;
// https://leetcode.com/problems/unique-morse-code-words/submissions/
public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        for(String word: words) {
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 97]);
            }
            System.out.println(res.toString());
            set.add(res.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
       Solution solution = new Solution();
       String[] words = {"gin", "zen", "gig", "msg"};
       int size = solution.uniqueMorseRepresentations(words);
       System.out.println("Size: " + size);
    }
}
