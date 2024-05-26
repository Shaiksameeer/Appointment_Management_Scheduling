package AppointmentManagementSystem_group_project;


import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppointmentManagementSystem system = AppointmentManagementSystem.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. Add Provider");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. Send Appointment Reminders");
            System.out.println("5. Conduct Performance Evaluations");
            System.out.println("6. Generate Financial Reports");
            System.out.println("7. Predict Resource Needs");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Patient ID: ");
                    String patientId = scanner.nextLine();
                    System.out.println("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    system.addPatient(new Patient(patientId, patientName));
                    break;
                case 2:
                    System.out.println("Enter Provider ID: ");
                    String providerId = scanner.nextLine();
                    System.out.println("Enter Provider Name: ");
                    String providerName = scanner.nextLine();
                    system.addProvider(new Provider(providerId, providerName));
                    break;
                case 3:
                    System.out.println("Enter Patient ID: ");
                    patientId = scanner.nextLine();
                    System.out.println("Enter Provider ID: ");
                    providerId = scanner.nextLine();
                    System.out.println("Enter Appointment Date (yyyy-MM-dd): ");
                    String dateStr = scanner.nextLine();
                    Date date = new Date(); // You may want to parse the date from the string
                    Patient patient = system.getPatients().stream().filter(p -> p.getId().equals(patientId)).findFirst().orElse(null);
                    Provider provider = system.getProviders().stream().filter(p -> p.getId().equals(providerId)).findFirst().orElse(null);
                    if (patient != null && provider != null) {
                        system.scheduleAppointment(patient, provider, date);
                    } else {
                        System.out.println("Patient or Provider not found!");
                    }
                    break;
                case 4:
                    system.setState(new ReminderState());
                    system.automateAppointmentReminders();
                    break;
                case 5:
                    system.setState(new ReportState());
                    system.conductPerformanceEvaluations();
                    break;
                case 6:
                    system.setState(new ReportState());
                    system.generateFinancialReports();
                    break;
                case 7:
                    system.setState(new AnalyticsState());
                    system.predictiveAnalyticsForResourcePlanning();
                    break;
             
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
