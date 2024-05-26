package Patient_Appointment_Management;
// State interface
public interface AppointmentState {
    void handle(Appointment appointment);
}