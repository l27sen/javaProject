package leetcodeByCategory.jacob;

/**
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 */
public class IntegerToRoman {

    public static void main(String[] args){
        System.out.println(intToRoman(14));
    }
    public static String intToRoman(int num) {
        // 注意每个字符串数组的空位
        String M[] = {"", "M", "MM", "MMM"};
        // 空，1000，2000，3000
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // 空，100，200，300，400，500，600，700，800，900
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // 空，10，20，30，40，50，60，70，80，90
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // 空，1，2，3，4，5，6，7，8，9
        return M[num / 1000] + C[(num / 100) % 10] + X[(num / 10) % 10] + I[num % 10];
        // M[千位] + c[百位] + x[十位] + i[个位]
    }
}
