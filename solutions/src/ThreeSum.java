import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/9].
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // skip same result
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = new ThreeSum().threeSum(input);

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (List<Integer> list : result) {
            sb.append("    [");
            for (Integer i : list) {
                sb.append(i).append(", ");
            }
            if (sb.indexOf(", ") != -1) {
                sb.replace(sb.lastIndexOf(", "), sb.length(), "");
            }
            sb.append("]");
            sb.append(",\n");
        }
        if (sb.indexOf(",") != -1) {
            sb.replace(sb.lastIndexOf(",\n"), sb.length(), "\n");
        }
        sb.append("]");

        System.out.println(sb.toString());
    }
}
