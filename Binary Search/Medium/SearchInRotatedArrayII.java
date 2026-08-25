class SearchInRotatedArrayII {

    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = nums[mid];

            if (val == target)
                return true;

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            if (nums[start] <= val) {
                if (nums[start] <= target && val >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (val <= target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 0;

        System.out.println(search(nums, target));
    }
}