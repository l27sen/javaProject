package leetcodeByCategory.jacob;

/**
 *
 * he string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {

    public static void main(String[] a){
        String input = "PAYPALISHIRING";
        System.out.println(convert(input, 3));
    }

    public static String convert(String s, int numRows){

        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int i = 0; i < numRows ; i++) {
            sbs[i] = new StringBuilder();
        }

        int i =0;

        while (i< s.length()){

            int curRow =0;
            //从上向下
            while (curRow< numRows && i< s.length()){
                sbs[curRow++].append(s.charAt(i++));
            }
            curRow=curRow -2;

            //从下向上
            while (curRow>0 && i< s.length()){

                sbs[curRow--].append(s.charAt(i++));
            }
        }
        StringBuilder result = new StringBuilder();

        for (int j = 0; j < numRows; j++) {
            result.append(sbs[j].toString());
        }
        return result.toString();
    }
}
