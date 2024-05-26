package Patient_Appointment_Management;
public class CancelledState implements AppointmentState {
    @Override
    public void handle(Appointment appointment) {
        System.out.println("Appointment is cancelled.");
    }
}