package leetcodeByCategory.jacob;

/**
 * 1-A
 * 26-Z
 * 27-AA.
 */
public class ExcelSheetTitle {


    public static void main(String[] args){
        System.out.println(convert(28));

    }
    public static String convert(int n){

        StringBuilder stringBuilder = new StringBuilder();
        while (n>0){
            n--;
            //A+1=B, A+2='C', so need to do n--
            stringBuilder.append((char)('A'+n%26));
            n= n/26;
        }
        return stringBuilder.reverse().toString();
    }
}
