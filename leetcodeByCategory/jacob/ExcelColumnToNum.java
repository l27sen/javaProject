package leetcodeByCategory.jacob;

/*

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
 */
public class ExcelColumnToNum {

    public static void main(String[] args){
        System.out.println(convert("AA"));
    }
    public static int convert(String s){

        int res =0;
        for(char c:s.toCharArray()){
            res = res*26+ (c-'A'+1);
        }
        return res;
    }
}
