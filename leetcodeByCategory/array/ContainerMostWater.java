package leetcodeByCategory.array;

/**
 * 两个板子之间， 最多水
 * 1) 设置两个指针
 * 2） 计算面积
 * 3）移动指针， 根据高度移动
 */
public class ContainerMostWater {

    public int maxAreaWater(int[] height) {
        int result = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            result = Math.max(result, (r - l) * Math.min(height[r], height[l]));

            //比较高度
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }

        }
        return result;
    }
}
