package Healthcare_provider_management;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProviderManager manager = ProviderManager.getInstance();
        RemotePatientMonitoring monitoring = new RemotePatientMonitoring();
        Scanner scanner = new Scanner(System.in);

        // Add providers
        HealthcareProvider provider1 = new HealthcareProvider("P1", "Alice Smith", "Cardiology");
        HealthcareProvider provider2 = new HealthcareProvider("P2", "Bob Jones", "Dermatology");

        manager.registerProvider(provider1);
        manager.registerProvider(provider2);

        try {
            // Schedule an appointment
            System.out.println("Enter appointment details (ID, Patient ID, Date [yyyy-MM-dd HH:mm], Details):");
            String appId = scanner.next();
            String patientId = scanner.next();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = sdf.parse(scanner.next() + " " + scanner.next());
            String details = scanner.next();
            Appointment appointment = new Appointment(appId, patientId, date, details);

            System.out.println("Enter provider ID to schedule the appointment:");
            String providerId = scanner.next();
            manager.scheduleAppointment(providerId, appointment);

            // View provider schedule
            System.out.println("Enter provider ID to view the schedule:");
            providerId = scanner.next();
            manager.viewProviderSchedule(providerId);

            // Conduct telemedicine appointment
            System.out.println("Enter telemedicine appointment details (ID, Patient ID, Date [yyyy-MM-dd HH:mm], Details):");
            appId = scanner.next();
            patientId = scanner.next();
            date = sdf.parse(scanner.next() + " " + scanner.next());
            details = scanner.next();
            TelemedicineAppointment teleAppointment = new TelemedicineAppointment(appId, patientId, date, details);

            System.out.println("Enter provider ID to conduct telemedicine appointment:");
            providerId = scanner.next();
            manager.conductTelemedicineAppointment(providerId, teleAppointment);

            // Monitor patient remotely
            System.out.println("Enter patient ID to monitor remotely:");
            patientId = scanner.next();
            monitoring.monitorPatient(patientId);

            // Update treatment plan
            System.out.println("Enter patient ID to update treatment plan:");
            patientId = scanner.next();
            monitoring.updateTreatmentPlan(patientId);


            // Monitor and update treatment plan for a patient in stable state
            System.out.println("Enter patient ID to monitor in stable state:");
          patientId = scanner.next();
            monitoring.monitorPatient(patientId);
            monitoring.updateTreatmentPlan(patientId);

            // Change state to CriticalState and monitor and update treatment plan again
            monitoring.setState(new CriticalState());
            System.out.println("Enter patient ID to monitor in critical state:");
            patientId = scanner.next();
            monitoring.monitorPatient(patientId);
            monitoring.updateTreatmentPlan(patientId);

            System.out.println("Enter patient ID to update treatment plan (Critical state):");
            patientId = scanner.next();
            monitoring.updateTreatmentPlan(patientId);

            // Integrate with EMR
            manager.integrateWithEMR();

            // Send provider reminders
            manager.sendProviderReminders();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
