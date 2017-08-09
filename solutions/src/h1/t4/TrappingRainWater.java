package h1.t4;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/26].
 */
public class TrappingRainWater {

    // brute force
    // time complexity O(n*n)
    // space complexity O(1)
//    public int trap(int[] height) {
//        int answer = 0;
//        int len = height.length;
//        for (int i = 1; i < len - 1; i++) {
//            int maxLeft = 0;
//            int maxRight = 0;
//            for (int j = i; j >= 0; j--) {
//                maxLeft = Math.max(maxLeft, height[j]);
//            }
//            for (int j = i; j < len; j++) {
//                maxRight = Math.max(maxRight, height[j]);
//            }
//            answer += Math.min(maxLeft, maxRight) - height[i];
//        }
//        return answer;
//    }

    // dynamic programming
    // time complexity O(n)
    // space complexity O(n)
//    public int trap(int[] height) {
//        int answer = 0;
//        int len = height.length;
//        int[] leftMax = new int[len];
//        int[] rightMax = new int[len];
//        for (int i = 1; i < len; i++) {
//            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
//        }
//        rightMax[len - 1] = height[len - 1];
//        for (int i = len - 2; i >= 0; i--) {
//            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
//        }
//        for (int i = 1; i < len - 1; i++) {
//            answer += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//        return answer;
//    }


    // Using stacks
    // time complexity O(n)
    // space complexity O(n)
//    public int trap(int[] height) {
//        int answer = 0;
//        int current = 0;
//        Stack<Integer> stack = new Stack<>();
//        while (current < height.length) {
//            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
//                int top = stack.pop();
//                if (stack.isEmpty()) {
//                    break;
//                }
//                int distance = current - stack.peek() - 1;
//                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
//                answer += distance * boundedHeight;
//            }
//            stack.push(current++);
//        }
//        return answer;
//    }

    // Using two pointers
    // time complexity O(n)
    // space complexity O(1)
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    answer = answer + leftMax - height[left];
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    answer = answer + (rightMax - height[right]);
                }
                --right;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(new TrappingRainWater().trap(height));
    }
}
