class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {

        int start = 0, end = num;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;

            if (square == num)
                return true;

            if (square > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int num = 36;

        System.out.println(isPerfectSquare(num));
    }
}