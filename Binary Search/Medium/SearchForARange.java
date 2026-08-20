import java.util.Arrays;

class SearchForARange {

    public static int findFirstAndLastPosition(int[] nums, int target, boolean isFirst) {
        int start = 0, end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;

                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };

        ans[0] = findFirstAndLastPosition(nums, target, true);
        if (ans[0] == -1)
            return ans;
        ans[1] = findFirstAndLastPosition(nums, target, false);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}