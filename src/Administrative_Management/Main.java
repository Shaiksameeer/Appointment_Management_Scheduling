package Administrative_Management;


import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdminManager adminManager = AdminManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of patients:");
        int numPatients = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < numPatients; i++) {
            System.out.println("Enter patient ID:");
            String patientId = scanner.nextLine();
            System.out.println("Enter patient name:");
            String patientName = scanner.nextLine();
            Patient patient = new Patient(patientId, patientName);
            System.out.println("Enter provider ID:");
            String providerId = scanner.nextLine();
            System.out.println("Enter provider name:");
            String providerName = scanner.nextLine();
            Provider provider = new Provider(providerId, providerName);
            System.out.println("Enter appointment date (yyyy-MM-dd):");
            String dateString = scanner.nextLine();
            Date date = new Date();  // For simplicity, using current date. Convert dateString to Date if needed.

            Appointment appointment = new Appointment(patient, provider, date);
            adminManager.getAppointments().add(appointment);
            adminManager.getProviders().add(provider);
        }

        // Using the state pattern for different administrative tasks
        adminManager.setState(new ReminderState());
        adminManager.automateAppointmentReminders();

        adminManager.setState(new ReportState());
        adminManager.conductPerformanceEvaluations();
        adminManager.generateFinancialReports();

    }
}
