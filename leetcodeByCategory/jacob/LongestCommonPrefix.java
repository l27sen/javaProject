package leetcodeByCategory.jacob;

/**
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 用第一个 string 整体当开始，然后遍历每个，把string减小
 */
public class LongestCommonPrefix {

    public static void main(String[] a){
        String[] test = {"flower","flow","flight"};
        System.out.println(getCommon(test));

    }
    public static String getCommon(String[] strs){

      String pre = strs[0];
        for (int i = 1; i < strs.length ; i++) {
            while (!strs[i].contains(pre)) {
                //make it shorter, flower->flowe
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
}
