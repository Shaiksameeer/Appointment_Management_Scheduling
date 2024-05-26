package Patient_Appointment_Management;
import java.util.*;

public class AppointmentManager implements AppointmentOperations {
    private static AppointmentManager instance;
     Map<String, Patient> patients;
     Map<String, Appointment> appointments;

    private AppointmentManager() {
        patients = new HashMap<>();
        appointments = new HashMap<>();
    }

    public static synchronized AppointmentManager getInstance() {
        if (instance == null) {
            instance = new AppointmentManager();
        }
        return instance;
    }

    // Register a new patient
    public void registerPatient(Patient patient) {
        patients.put(patient.getId(), patient);
    }

    @Override
    public void scheduleAppointment(String appointmentId, String patientId, Date date, String details) {
        if (!patients.containsKey(patientId)) {
            throw new IllegalArgumentException("Patient not found.");
        }
        Appointment appointment = new Appointment(appointmentId, patientId, date, details);
        appointments.put(appointmentId, appointment);
        appointment.applyState();
    }

    @Override
    public void cancelAppointment(String appointmentId) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment != null) {
            appointment.setState(new CancelledState());
            appointment.applyState();
            appointments.remove(appointmentId);
            System.out.println("Appointment cancelled successfully.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    @Override
    public void viewAppointmentHistory(String patientId) {
        if (!patients.containsKey(patientId)) {
            throw new IllegalArgumentException("Patient not found.");
        }
        for (Appointment appointment : appointments.values()) {
            if (appointment.getPatientId().equals(patientId)) {
                System.out.println("Appointment ID: " + appointment.getAppointmentId() +
                        ", Date: " + appointment.getDate() +
                        ", Details: " + appointment.getDetails());
            }
        }
    }

    // Reschedule an appointment
    public void rescheduleAppointment(String appointmentId, Date newDate) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment != null) {
            appointment.setState(new RescheduledState());
            appointment.applyState();
            appointment.setDate(newDate);
        } else {
            throw new IllegalArgumentException("Appointment not found.");
        }
    }

    // Send appointment reminders (dummy method)
    public void sendAppointmentReminders() {
        for (Appointment appointment : appointments.values()) {
            System.out.println("Reminder: Appointment ID " + appointment.getAppointmentId() +
                    " is scheduled on " + appointment.getDate());
        }
    }
}
