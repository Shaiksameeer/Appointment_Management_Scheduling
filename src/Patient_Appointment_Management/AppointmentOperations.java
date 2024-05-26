package Patient_Appointment_Management;
import java.util.Date;

public interface AppointmentOperations {
    void scheduleAppointment(String appointmentId, String patientId, Date date, String details);
    void cancelAppointment(String appointmentId);
    void viewAppointmentHistory(String patientId);
}
