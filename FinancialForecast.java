public class FinancialForecast {

    static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0)
            return presentValue;
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    static double[] memo = new double[1000];

    static double futureValueMemo(double presentValue, double growthRate, int years) {
        if (years == 0)
            return presentValue;
        if (memo[years] != 0)
            return memo[years];
        memo[years] = futureValueMemo(presentValue, growthRate, years - 1) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {

        double presentValue = 10000;
        double growthRate = 0.08;
        int years = 5;

        System.out.println("Present Value : Rs." + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println();

        double result = futureValue(presentValue, growthRate, years);
        System.out.printf("Future Value (Recursive) : Rs.%.2f%n", result);

        double resultMemo = futureValueMemo(presentValue, growthRate, years);
        System.out.printf("Future Value (Memoized)  : Rs.%.2f%n", resultMemo);

        System.out.println();
        System.out.println("--- Year by Year Forecast ---");
        for (int y = 1; y <= years; y++) {
            double fv = futureValue(presentValue, growthRate, y);
            System.out.printf("Year %d : Rs.%.2f%n", y, fv);
        }

        System.out.println();
        System.out.println("--- Time Complexity Analysis ---");
        System.out.println("Recursive : O(n) - one call per year");
        System.out.println("Memoized  : O(n) time, O(n) space - avoids repeated calls");
        System.out.println("Iterative : O(n) time, O(1) space - most efficient for this problem");
    }
}