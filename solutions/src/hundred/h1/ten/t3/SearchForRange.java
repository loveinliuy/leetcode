package hundred.h1.ten.t3;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/21].
 */
public class SearchForRange {

    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;

        int low = 0;
        int high = nums.length - 1;


        while (low <= high) {
            if(low == high && nums[low] == target){
                start = low;
                end = high;
                break;
            }

            int mid = (low + high) / 2;//low + (high - low) >> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                start = mid;
                end = mid;
                while (--start >= 0 && nums[start] == target) ;
                start++;
                while (++end < nums.length && nums[end] == target) ;
                end--;
                break;
            }

        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int target = 2;

        int[] result = new SearchForRange().searchRange(nums, target);

        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
