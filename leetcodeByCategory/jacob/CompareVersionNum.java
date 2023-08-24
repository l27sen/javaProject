package leetcodeByCategory.jacob;

/**
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 *
 *
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 */
public class CompareVersionNum {

    //convert to array, then compare
    public int compare(String version1, String version2){
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {

            int num1 = i< v1.length? Integer.parseInt(v1[i]):0;
            int num2 = i< v2.length? Integer.parseInt(v2[i]):0;

            if(num1<num2){
                return -1;
            }else if(num1>num2){
                return 1;
            }
        }
        return 0;
    }
}
