class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int start = 0, end = (m * n) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target)
                return true;

            if (matrix[row][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}