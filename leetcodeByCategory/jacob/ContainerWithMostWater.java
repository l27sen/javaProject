package leetcodeByCategory.jacob;

public class ContainerWithMostWater {

    public int max(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {

            int min = Math.min(height[left], height[right]);
            max = Math.max(max, min * (right - left));
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
