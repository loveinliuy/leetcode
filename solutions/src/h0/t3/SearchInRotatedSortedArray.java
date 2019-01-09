package h0.t3;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/21].
 */
public class SearchInRotatedSortedArray {

    // solution using binary search
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) >> 1;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low] == target ? low : -1;
    }

//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        if (target > nums[0]) {
//            // find ahead
//            for (int i = 1; i < nums.length; i++) {
//                if (target == nums[i]) {
//                    return i;
//                }
//                if (nums[i] <= nums[i - 1]) {
//                    break;
//                }
//            }
//        } else if (target < nums[0]) {
//            // find behind
//            for (int i = nums.length - 1; i > 0; i--) {
//                if (target == nums[i]) {
//                    return i;
//                }
//                if (nums[i] <= nums[i - 1]) {
//                    break;
//                }
//            }
//        } else {
//            return 0;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int target = 1;

        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }
}
