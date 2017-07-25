/**
 * description:
 *
 * @author zhangshibo  [2017/7/20].
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int lastPos2Reverse = nums.length - 1 - 1;
        // find the num not bigger than the previous
        while (lastPos2Reverse >= 0 && nums[lastPos2Reverse] >= nums[lastPos2Reverse + 1]) {
            lastPos2Reverse--;
        }

        if (lastPos2Reverse >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[lastPos2Reverse]) {
                j--;
            }
            swap(nums, lastPos2Reverse, j);
        }

        reverse(nums, lastPos2Reverse + 1);
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int pos) {
        int start = pos;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};

        new NextPermutation().nextPermutation(nums);

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
