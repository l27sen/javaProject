package leetcode;

public class GriddlePossibility {

    public static void main(String[] a){
        PrintProbaility(2);
    }

    private static void PrintProbaility(int n){
        if(n<=0){
            return;
        }
        int[] pros = new int[6*n-n+1];//因为共有6n-n+1种的s，所有创建一个这样大小的数组来存放每种的次数
        Probaility(pros,n);
        int total = (int) Math.pow(6, n);
        for(int i=n;i<=6*n;i++){
            System.out.println(i+":"+pros[i-n]+"/"+total);
        }
    }

    private static void Probaility(int[] pros,int n){
        for(int i=1;i<=6;i++){
            Probaility(n,n,i,pros);
        }
    }


    /**
     * @param original      总的色子数
     * @param current       剩余要处理的色子数
     * @param sum           已经前面的色子数和
     * @param pros 不同色子数出现次数的计数数组
     */

    private static void Probaility(int original, int current, int sum, int[] pros) {
        if (current == 1) {
            pros[sum - original]++;
        } else {
            for (int i = 1; i <= 6; i++) {
                Probaility(original, current - 1, i + sum, pros);
            }
        }
    }

}
