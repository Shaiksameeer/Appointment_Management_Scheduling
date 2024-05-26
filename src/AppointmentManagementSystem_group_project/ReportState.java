package AppointmentManagementSystem_group_project;


import java.util.List;

public class ReportState implements SystemState {
    @Override
    public void handleRequest() {
        generateReports();
    }

    public void evaluatePerformance(List<Provider> providers) {
        System.out.println("Evaluating performance of providers...");

        // Example logic: Print a basic evaluation for each provider
        for (Provider provider : providers) {
            System.out.println("Provider: " + provider.getName() + " - Performance: Good");
        }
    }

    public void generateReports() {
        System.out.println("Generating financial reports...");

        // Example logic: Generate and print a basic financial report
        double totalRevenue = 50000; // Placeholder for actual calculation
        double totalExpenses = 30000; // Placeholder for actual calculation
        double netProfit = totalRevenue - totalExpenses;

        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Net Profit: $" + netProfit);
    }
}
