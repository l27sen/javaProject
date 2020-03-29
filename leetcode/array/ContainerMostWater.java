package leetcode.array;

/**
 * 两个板子之间， 最多水
 */
public class ContainerMostWater {


    public int maxAreaWater(int[] height){
        int result =0;
        int l=0, r = height.length-1;
        while (l<r){
            result= Math.max(result, Math.min(l,r)*(r-l));
            //find 高的板子
            if(l<r){
                l++;
            }else{
                r--;
            }
        }
        return result;
    }
}
