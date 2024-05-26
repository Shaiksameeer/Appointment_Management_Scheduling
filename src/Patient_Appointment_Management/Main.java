package Patient_Appointment_Management;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentManager manager = AppointmentManager.getInstance();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Reschedule Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. View Appointment History");
            System.out.println("6. Send Appointment Reminders");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String patientId = scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Patient Email: ");
                    String email = scanner.nextLine();
                    Patient patient = new Patient(patientId, name, email);
                    manager.registerPatient(patient);
                    System.out.println("Patient registered successfully.");
                    break;

                case 2:
                    System.out.print("Enter Appointment ID: ");
                    String appointmentId = scanner.nextLine();
                    System.out.print("Enter Patient ID: ");
                    patientId = scanner.nextLine();
                    System.out.print("Enter Appointment Date (yyyy-MM-dd HH:mm): ");
                    String dateStr = scanner.nextLine();
                    Date date = parseDate(dateStr);
                    System.out.print("Enter Appointment Details: ");
                    String details = scanner.nextLine();
                    manager.scheduleAppointment(appointmentId, patientId, date, details);
                    break;

                case 3:
                    System.out.print("Enter Appointment ID to Reschedule: ");
                    appointmentId = scanner.nextLine();
                    System.out.print("Enter New Appointment Date (yyyy-MM-dd HH:mm): ");
                    dateStr = scanner.nextLine();
                    date = parseDate(dateStr);
                    manager.rescheduleAppointment(appointmentId, date);
                    break;

                case 4:
                    System.out.print("Enter Appointment ID to Cancel: ");
                    appointmentId = scanner.nextLine();
                    manager.cancelAppointment(appointmentId);
                    break;

                case 5:
                    System.out.print("Enter Patient ID to View History: ");
                    patientId = scanner.nextLine();
                    manager.viewAppointmentHistory(patientId);
                    break;

                case 6:
                    manager.sendAppointmentReminders();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException("Invalid date format. Please use yyyy-MM-dd HH:mm.");
        }
    }
}
