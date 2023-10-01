package leetcodeByCategory.other;

/**
 * **  *
 * *****  **
 * 0 1 0 2 0 0 3 2 0 0 2 1
 * left      right pointer
 */
public class TappingRainWater {

    /**
     * value in height means the height of each *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int result = 0;
        int leftMax = 0;
        int rightMax = 0;

        //两个指针左右移动，来找 Min （L，R）
        while (left < right) {
            //add water in left side
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                result += leftMax - height[left];
                left++;
            }
            //caculate water in right side
            else {
                rightMax = Math.max(height[right], rightMax);
                result += rightMax - height[right];
                right--;

            }
        }

        return result;
    }
}
