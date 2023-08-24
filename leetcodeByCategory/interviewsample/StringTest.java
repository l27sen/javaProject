package leetcodeByCategory.interviewsample;

import java.util.Arrays;

public class StringTest {

   private char[] value;
    public static void main(String[] args) {
       final char[] chars = {'a','b'};
       chars[0]= 'd';
       System.out.println(Arrays.toString(chars));
       String abc = "abc";
       abc.replace('a','c');
       System.out.println(abc);

    }

    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String) anObject;
            int n = value.length;
            if (n == anotherString.toCharArray().length) {
                char v1[] = value;
                char v2[] = anotherString.toCharArray();
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }


    public String substring(int beginIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }
        int subLen = value.length - beginIndex;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }
        return new String(value, beginIndex, subLen);
    }
}
