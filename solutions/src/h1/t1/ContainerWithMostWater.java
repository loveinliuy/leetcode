package h1.t1;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/8].
 */
public class ContainerWithMostWater {

    // mine
//    public int maxArea(int[] height) {
//        int start = 0, end = height.length - 1;
//        int maxArea = 0;
//        while (start < end) {
//            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * (end - start));
//            if (height[start] < height[end]) {
//                start++;
//            } else {
//                end--;
//            }
//        }
//        return maxArea;
//    }

    // better solution: considering the continuously circumstances while moving the pointer
    // amazing using of the operator '&&'
    public int maxArea(int[] height) {
        int front = 0;
        int end = height.length - 1;
        int a = 0;
        while (end > front) {
            int left = height[front];
            int right = height[end];
            a = Math.max(a, Math.min(left, right) * (end - front));
            if (left < right) {
                while (height[front] <= left && front++ < height.length - 1) ;
            } else {
                while (height[end] <= right && end-- > 0) ;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] input = new int[15000];
        for (int i = input.length - 1; i > 0; i--) {
            input[i] = i + 1;
        }

        System.out.println(new ContainerWithMostWater().maxArea(input));
    }
}
