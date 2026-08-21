class SqrtX {

    public static int mySqrt(int x) {

        int start = 0, end = x;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            long sqrt = (long) mid * mid;

            if(sqrt == x) return mid;

            if(sqrt > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        int x = 9;

        System.out.println(mySqrt(x));
    }
}