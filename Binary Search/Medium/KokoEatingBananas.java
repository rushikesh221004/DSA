class KokoEatingBananas {

    public static long calculateHrs(int[] piles, int h, int speed) {
        long totalHrs = 0;

        for (int pile : piles) {
            totalHrs += (pile + speed - 1) / speed;

            if (totalHrs > h)
                return totalHrs;
        }

        return totalHrs;
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int start = 1, end = Integer.MIN_VALUE;

        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        int ans = 0;

        while (start <= end) {
            int speed = start + (end - start) / 2;

            long totalHrs = calculateHrs(piles, h, speed);

            if (totalHrs <= h) {
                ans = speed;

                end = speed - 1;
            } else {
                start = speed + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}