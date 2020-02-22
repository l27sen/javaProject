package topleetcode.binary;

public class TwoSumWithoutPlus {

    public static int addIterative(int a, int b) {
        while (b != 0) {
            int carry = (a & b); //CARRY is AND of two bits

            a = a ^ b; //SUM of two bits is A XOR B

            b = carry << 1; //shifts carry to 1 bit to calculate sum
        }
        return a;
    }


}
