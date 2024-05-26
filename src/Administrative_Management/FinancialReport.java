package Administrative_Management;


public class FinancialReport {
    private String period;
    private double revenue;
    private double costs;
    private double profit;

    public FinancialReport(String period, double revenue, double costs, double profit) {
        this.period = period;
        this.revenue = revenue;
        this.costs = costs;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "FinancialReport{" +
                "period='" + period + '\'' +
                ", revenue=" + revenue +
                ", costs=" + costs +
                ", profit=" + profit +
                '}';
    }
}
