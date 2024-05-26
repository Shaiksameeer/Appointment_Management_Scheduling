package AppointmentManagementSystem_group_project;

import java.util.*;

public class AppointmentManagementSystem {
    private static AppointmentManagementSystem instance;
    private List<Patient> patients;
    private List<Provider> providers;
    private List<Appointment> appointments;
    private SystemState state;

     AppointmentManagementSystem() {
        patients = new ArrayList<>();
        providers = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public static synchronized AppointmentManagementSystem getInstance() {
        if (instance == null) {
            instance = new AppointmentManagementSystem();
        }
        return instance;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setState(SystemState state) {
        this.state = state;
    }

    public SystemState getState() {
        return state;
    }

    // Patient Management
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void managePatients() {
        for (Patient patient : patients) {
            System.out.println("Managing patient: " + patient.getName());
        }
    }

    // Provider Management
    public void addProvider(Provider provider) {
        providers.add(provider);
    }

    public void manageProviders() {
        for (Provider provider : providers) {
            System.out.println("Managing provider: " + provider.getName());
        }
    }

    // Appointment Scheduling
    public void scheduleAppointment(Patient patient, Provider provider, Date date) {
        Appointment appointment = new Appointment(patient, provider, date);
        appointments.add(appointment);
        System.out.println("Scheduled appointment for patient " + patient.getName() + " with provider " + provider.getName() + " on " + date);
    }

    // State-Based Functionalities
    public void automateAppointmentReminders() {
        if (state instanceof ReminderState) {
            ((ReminderState) state).sendReminders(appointments);
        }
    }

    public void conductPerformanceEvaluations() {
        if (state instanceof ReportState) {
            ((ReportState) state).evaluatePerformance(providers);
        }
    }

    public void generateFinancialReports() {
        if (state instanceof ReportState) {
            ((ReportState) state).generateReports();
        }
    }

    public void predictiveAnalyticsForResourcePlanning() {
        if (state instanceof AnalyticsState) {
            ((AnalyticsState) state).predictResourceNeeds();
        }
    }

  
   
}
