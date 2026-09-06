class CapacityToShipPackagesWithinDDays {

    private static int calculateDays(int[] weights, int days, int capacity) {
        int d = 1;
        int sum = 0;

        for (int weight : weights) {
            if (sum + weight > capacity) {
                sum = 0;
                d++;
            }
            if (d > days)
                return d;
            sum += weight;
        }

        return d;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE, end = 0;

        for (int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }

        int ans = 0;

        while (start <= end) {
            int capacity = start + (end - start) / 2;

            int totalDays = calculateDays(weights, days, capacity);

            if (totalDays <= days) {
                ans = capacity;

                end = capacity - 1;
            } else {
                start = capacity + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}