//Longest Common Prefix
//Input: ["flower","flow","flight"]
//Output: "fl"
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        //flower, 3
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[i].charAt(j) == strs[j].charAt(j)) {
                    prefix = strs[i].substring(0, i);
                }
            }
        }

        return prefix;
    }
}
class Driver1{
    public static void main(String []args){
        String []str = new String[] {"flower", "fl", "a"};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String result = lcp.longestCommonPrefix(str);
        System.out.println(result);
    }
}
