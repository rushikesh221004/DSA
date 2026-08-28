class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == nums[end]) {
                end--;
                continue;
            }

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 0, 1 };

        System.out.println(findMin(nums));
    }
}