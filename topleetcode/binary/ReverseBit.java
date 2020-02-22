package topleetcode.binary;

public class ReverseBit {
    public static void main(String[] args){
        int a = 43261596 ;
        System.out.println(Integer.toBinaryString(reverseBits(a)));
    }


    // you need treat n as an unsigned value
    public static int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n = (n >> 1);

            /** similar to this:
            ans = ans*2+ ans%2;
            ans = ans/2;
             */
        }

        return result;
    }
}
