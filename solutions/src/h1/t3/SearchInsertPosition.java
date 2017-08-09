package h1.t3;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/21].
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
//        return nums[mid] > target ? mid : mid + 1;
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;

        System.out.println(new SearchInsertPosition().searchInsert(nums, target));
    }
}
