class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = nums[mid];

            if (val == target)
                return mid;

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

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 2;

        System.out.println(search(nums, target));
    }
}