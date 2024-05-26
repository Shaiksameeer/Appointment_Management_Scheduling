package Administrative_Management;


public class Provider {
    private String id;
    private String name;
    private String performanceReview;

    public Provider(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void evaluatePerformance() {
        // Simulating performance evaluation logic
        this.performanceReview = "Excellent";
        System.out.println("Performance review for provider " + name + ": " + performanceReview);
    }

    public String getPerformanceReview() {
        return performanceReview;
    }
}
