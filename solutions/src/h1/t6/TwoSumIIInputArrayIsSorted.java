package h1.t6;

import utils.PrintHelper;

/**
 * @author zhangshibo
 */
public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum > target) {
                    break;
                } else if (sum < target) {
                    continue;
                } else {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public int[] twoSumB(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PrintHelper.printArray(new TwoSumIIInputArrayIsSorted().twoSumB(new int[]{3, 24, 50, 79, 88, 150, 345}, 200));
    }
}
