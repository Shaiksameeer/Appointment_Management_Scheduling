package AppointmentManagementSystem_group_project;

public class SecurityState implements SystemState {
    @Override
    public void handleRequest() {
        // Handle request specific to security state
    }

    public void checkCompliance() {
        System.out.println("Checking regulatory compliance...");
    }

    public void secureData() {
        System.out.println("Ensuring data security and privacy...");
    }
}
